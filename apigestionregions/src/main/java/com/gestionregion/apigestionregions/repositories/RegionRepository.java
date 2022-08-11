package com.gestionregion.apigestionregions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionregion.apigestionregions.models.Regions;

public interface RegionRepository extends JpaRepository<Regions,Long>{
    
}
