package com.MaliTourist.Apigestionregions.Repository;

import com.MaliTourist.Apigestionregions.modele.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegionRepo extends JpaRepository<Region,Long> {


    //pour recuperer la valeur d'un attribut dans la base de donnée
   // Region findByNom_Region(String nom_region);

    @Query(value = "SELECT nom_region FROM `region`", nativeQuery = true)

    Iterable<Object[]> listeRegionSansPays();


    @Query(value = "SELECT pays.nom_pays, region.nom_region FROM `pays`, `region` WHERE region.pays_id = pays.id AND ", nativeQuery = true )
    Iterable<Object[]> listeRegionAvecPays();



    @Query(value = "SELECT region.nom_region FROM `region`, `pays` WHERE region.pays_id = pays.id AND " +
            "pays.nom_pays = :pays " ,nativeQuery = true)
    Iterable<Object[]> listeRegionParPays(@Param("pays") String pays);



/*
//Ajouter dans les deux table (Region et populaion)
    @Query(value="BEGIN; " +
            "INSERT INTO region (code_region,domaine_activite,langue, nom_region,superficie, pays_id )  " +
            " VALUES(:code, :domaine, :langue, :nom, :superficie, :idpays);" +
            " INSERT INTO population (annee, habitants,region_id)  " +
            "  VALUES(:annee,:habitant, last_insert_id();" +
            " COMMIT;", nativeQuery = true)
    Iterable<Object[]> insererRegionPopulation( String code,
            String domaine,  String langue, String nom
    ,  String superficie, String idpays,
 Date annee, int habitant);
*/


// Rechercher une region avec son nom

    @Query(value ="SELECT id FROM region WHERE nom_region = :nom" , nativeQuery = true)
    Iterable<Object[]> afficherRegionAvecParametre(@Param("nom") String nom);


}
