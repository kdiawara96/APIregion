package com.MaliTourist.Apigestionregions.Repository;

import com.MaliTourist.Apigestionregions.modele.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegionRepo extends JpaRepository<Region,Long> {

    @Query(value = "SELECT nom FROM `region`", nativeQuery = true)
    Iterable<Object[]> listeRegionSansPays();


    @Query(value = "SELECT pays.nom_pays, region.nom FROM `pays`, `region` WHERE region.pays_id = pays.id", nativeQuery = true )
    Iterable<Object[]> listeRegionAvecPays();

    @Query(value = "SELECT region.nom FROM `region`, `pays` WHERE region.pays_id = pays.id AND pays.nom_pays = :pays " ,nativeQuery = true)
    List<Object[]> listeRegionParPays(@Param("pays") String pays);



}
