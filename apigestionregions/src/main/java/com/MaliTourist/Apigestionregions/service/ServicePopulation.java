package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.modele.Population;

import java.util.List;

public interface ServicePopulation {

    //population

    Population modifierPopulation(Long id, Population population);
    String supprimerPopulation(Long id);
    List<Population> listerPopulation();
    Population ajouterPopulation(Population population);
}
