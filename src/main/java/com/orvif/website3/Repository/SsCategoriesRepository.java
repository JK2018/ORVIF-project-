package com.orvif.website3.Repository;


import com.orvif.website3.Entity.Categories;
import com.orvif.website3.Entity.SsCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SsCategoriesRepository extends JpaRepository<SsCategories, Integer> {

    // for method getIdByName in ProduitsHelper
    //this query is a dynamic query in several repositories , check method in ProduitsHelper
    @Query(value = "SELECT id_sscategories FROM ss_categories WHERE libelle = :libelle" , nativeQuery = true)
    int getIdByName(@Param("libelle") String libelle);




    // for method getGroupeByProduct in ProduitsHelper
    @Query(value = "SELECT * FROM SS_CATEGORIES SC, PRODUITS P WHERE SC.id_sscategories=P.id_sscategories AND P.id_produits = :id_produits" , nativeQuery = true)
    SsCategories getByIdProduit(@Param("id_produits") int id_produits);






}
