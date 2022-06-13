package org.std;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.std.dao.ProduitRepository;
import org.std.entities.Produit;

@SpringBootApplication
public class MvcProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MvcProjectApplication.class, args);
		/*ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("Produit 1", 120, 500));
		produitRepository.save(new Produit("Produit 2", 100, 270));
		produitRepository.save(new Produit("Produit 3", 645, 150));
		produitRepository.save(new Produit("Produit 4", 1100, 210));
		List<Produit> produits = produitRepository.findAll();
		produits.forEach(p-> System.out.println(p.toString()));*/
		
	}

}
