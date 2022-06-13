package org.std.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.std.dao.ProduitRepository;
import org.std.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/user/index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/user/index")
	public String index(Model model,@RequestParam(name="page",defaultValue = "0")int p,
			@RequestParam(name="size",defaultValue = "5")int s,
			@RequestParam(name="motCle",defaultValue = "")String mc) {
		Page<Produit> produits = produitRepository.findByDesignationIgnoreCaseContaining(mc,PageRequest.of(p, s));
		int pagesCount = produits.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) pages[i]=i;
		model.addAttribute("totalPage",pagesCount);
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("size", s);
		model.addAttribute("pageProduits", produits);
		model.addAttribute("motCle",mc);
		return "produits";
	}
	
	@RequestMapping(value="/admin/delete")
	public String delete(Long id,int page,int size,String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/user/index?page="+page+"&size="+size+"&motCle="+motCle;
	}
	
	@RequestMapping(value="/admin/form",method = RequestMethod.GET)
	public String FormProduit(Model model) {
		model.addAttribute("produit",new Produit());
		return "formProduit";
	}
	
	@RequestMapping(value="/admin/save",method = RequestMethod.POST)
	public String save(@Valid Produit produit,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formProduit";	
		}
		produitRepository.save(produit);
		return "confirmation";
		
	}
	@RequestMapping(value="/admin/edit")
	public String edit(Long id,Model model) {
	  Produit pr = produitRepository.getById(id);
	  model.addAttribute("produit", pr);
		return "editProduit";
	}
	
	@RequestMapping(value="/editProduit",method = RequestMethod.POST)
	public String update(@Valid Produit produit,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "editProduit";	
		}
		produitRepository.save(produit);
		return "redirect:/user/index";
		
	}
	
	@RequestMapping(value = "/403")
	public String accessDenied() {
		return "403";
	}
}
