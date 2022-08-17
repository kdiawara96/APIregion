package com.MaliTourist.Apigestionregions.service;

import java.util.List;

public interface ServiceNative {

    //methode natif

    //lister region sans pays
    List<Object[]> listeRegionSansPays();

    //lister region avec pays
    List<Object[]> listeRegionAvecPays();

    List<Object[]> listeRegionParPays(String pays);


    //lister la population par rapport aux regions

    List<Object[]> listePopulationAnneeParRegion(String region);

    //Afficher le pays, la region, la population, l'habitant et l'année

    List<Object[]> liste_pays_region_population(String pays);


    //afficher region à travers le nom donner
    List<Object[]> afficherRegionAvecParametre(String nom);



}
