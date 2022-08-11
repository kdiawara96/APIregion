package com.gestionregion.apigestionregions.models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor // constucteur avec tous les paramètres
@NoArgsConstructor // constucteur sans paramètre

public class Populations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generation des id automatiquement
private int Id_population ;
private int population;


    
}
