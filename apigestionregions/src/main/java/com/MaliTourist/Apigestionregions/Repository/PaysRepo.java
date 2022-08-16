package com.MaliTourist.Apigestionregions.Repository;

import com.MaliTourist.Apigestionregions.modele.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaysRepo extends JpaRepository <Pays,Long> {



    @Query(value = "SELECT pays.nom_pays, region.nom_region, population.annee, population.habitant FROM " +
            "`pays`,`region`,`population` " +
            "WHERE region.pays_id = pays.id " +
            "AND population.region_id = region.id AND " +
            "pays.nom_pays = :pays", nativeQuery = true)
    Iterable<Object[]> liste_pays_region_population(@Param("pays") String pays);

    Pays findByNomPays(String nomPays);
}
