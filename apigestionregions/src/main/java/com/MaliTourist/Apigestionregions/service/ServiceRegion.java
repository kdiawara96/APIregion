package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.modele.Region;

import java.util.List;

public interface ServiceRegion {

    Region ajouterRegion(Region region);
    String supprimerRegion(Long id);
    List<Region> listerRegion();
    Region modifierRegion(Long id, Region region);

    // Methode pour la recuperation d'un pays à travers le nom
    //Region getRegionByNom_region(String nom_pays);


}
