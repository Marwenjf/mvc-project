package org.std.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.std.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.designation like %:mc%")
	Page<Produit> chercher(@Param("mc") String mc,Pageable pageable);
	Page<Produit> findByDesignationIgnoreCaseContaining(String mc,Pageable pageable);
}
