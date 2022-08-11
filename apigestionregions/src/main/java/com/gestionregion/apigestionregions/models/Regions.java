package com.gestionregion.apigestionregions.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Table(name="regions")

@Data //getter & setter
@AllArgsConstructor // constucteur avec tous les paramètres
@NoArgsConstructor  // constucteur sans paramètre


public class Regions{
 
    // generation des id automatiquement
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id_region;

    //lmp = la langue majoritairement parler
    // sup_region = superficie region
    

    @Column(name="CODE_REGION", length=25)
    private String code_region;
    
    @Column(name="NOM_REGION")
    private String nom_region;

    @Column(name="SUP_REGION")
    private int sup_region;

    @Column(name="DOMAINE_ACTIVITE")
    private String domaine_activite;

    @Column(name="LMP")
    private String lmp;

}
