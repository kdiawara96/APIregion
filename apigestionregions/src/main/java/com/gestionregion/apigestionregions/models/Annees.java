package com.gestionregion.apigestionregions.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //im
@NoArgsConstructor   // constructeur sans paramètre
@AllArgsConstructor // constructeur avec tous les paramètres

public class Annees {
    @Id 
    @GeneratedValue( strategy = GenerationType.IDENTITY) //genère les id automatiquement

    private int id_annee;
    private Date  annee;
    
}
