package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.modele.Pays;

import java.util.List;

public interface ServicePays {

    //pays

    Pays ajouterPays(Pays pays);
    Pays modifierPays(Long id, Pays pays);
    String supprimerPays(Long id);
    List<Pays> listerPays();
   Pays getNomPays(Pays pays);
}
