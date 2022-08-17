package com.MaliTourist.Apigestionregions.Repository;

import com.MaliTourist.Apigestionregions.modele.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PopulationRepo extends JpaRepository<Population,Long> {

    //lister la population, l'année par rapport à la region
    @Query(value ="SELECT population.annee, population.habitant FROM population, " +
            "region WHERE population.region_id = region.id AND region.nomregion = :region", nativeQuery = true)
    List<Object[]> listePopulationAnneeParRegion(@Param("region") String region);


}
