package com.gestionregion.apigestionregions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionregion.apigestionregions.models.Pays;

public interface PaysRepository extends JpaRepository<Pays,Long> {
    
}
