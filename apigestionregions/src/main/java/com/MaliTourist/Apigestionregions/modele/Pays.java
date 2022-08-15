package com.MaliTourist.Apigestionregions.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "pays")
@Table(name = "pays")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_pays;

    //@OneToMany(mappedBy = "pays")
    //private Collection<Region> region;

}
