package com.MaliTourist.Apigestionregions.Repository;

import com.MaliTourist.Apigestionregions.modele.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PopulationRepo extends JpaRepository<Population,Long> {

    @Query(value ="SELECT population.annee, population.habitant FROM population, region WHERE population.region_id = region.id AND region.nom = :region", nativeQuery = true)
    List<Object[]> listePopulationAnneeParRegion(@Param("region") String region);


}
