package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.modele.Population;
import com.MaliTourist.Apigestionregions.modele.Region;

import java.util.List;

public interface Services {

    //Region

    Region ajouterRegion(Region region);
    String supprimerRegion(Long id);
    List<Region> listerRegion();
    Region modifierRegion(Long id, Region region);

    //population


    Population modifierPopulation(Long id, Population population);
    String supprimerPopulation(Long id);
    List<Population> listerPopulation();
    Population ajouterPopulation(Population population);


    //pays

    Pays ajouterPays(Pays pays);
    Pays modifierPays(Long id, Pays pays);
    String supprimerPays(Long id);
    List<Pays> listerPays();


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
}
