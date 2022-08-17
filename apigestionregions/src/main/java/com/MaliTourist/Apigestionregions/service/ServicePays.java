package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.modele.Pays;

import java.util.List;

public interface ServicePays {

    //pays

    Pays ajouterPays(Pays pays);
    Pays modifierPays(Long id, Pays pays);
    String supprimerPays(Long id);
    List<Pays> listerPays();
    //cette methode va nous permettre de verifier le pays dans la base de données
   Pays getNompays(Pays pays);
}
