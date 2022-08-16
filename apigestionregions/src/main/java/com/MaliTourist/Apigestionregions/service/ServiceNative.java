package com.MaliTourist.Apigestionregions.service;

public interface ServiceNative {

    //methode natif

    //lister region sans pays
    Iterable<Object[]> listeRegionSansPays();

    //lister region avec pays
    Iterable<Object[]> listeRegionAvecPays();

    Iterable<Object[]> listeRegionParPays(String pays);


    //lister la population par rapport aux regions

    Iterable<Object[]> listePopulationAnneeParRegion(String region);

    //Afficher le pays, la region, la population, l'habitant et l'année

    Iterable<Object[]> liste_pays_region_population(String pays);


    //afficher region à travers le nom donner
    Iterable<Object[]> afficherRegionAvecParametre(String nom);



}
