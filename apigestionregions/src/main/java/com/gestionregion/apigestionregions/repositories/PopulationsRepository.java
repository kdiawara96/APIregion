package com.gestionregion.apigestionregions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionregion.apigestionregions.models.Populations;

public interface PopulationsRepository extends JpaRepository<Populations,Long> {
    
}
