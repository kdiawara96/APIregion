package com.MaliTourist.Apigestionregions.Repository;

import com.MaliTourist.Apigestionregions.modele.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaysRepo extends JpaRepository <Pays,Long> {


   //Lister le pays, la region, population par rapport au pays donné
    @Query(value = "SELECT pays.nompays, region.nomregion, population.annee, population.habitant FROM " +
            "`pays`,`region`,`population` " +
            "WHERE region.pays_id = pays.id " +
            "AND population.region_id = region.id AND " +
            "pays.nompays = :pays", nativeQuery = true)
    List<Object[]> liste_pays_region_population(@Param("pays") String pays);


    Pays findByNompays(String nompays);
}
