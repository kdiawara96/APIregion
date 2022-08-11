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

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="PAYS") 

public class Pays {

    //sup_pays = superficie pays

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generation des id automatiquement
    private Long id;

    @Column(name="nom_pays")
    private String nom_pays;
    @Column(name="sup_pays")
    private int sup_pays;

    
}
