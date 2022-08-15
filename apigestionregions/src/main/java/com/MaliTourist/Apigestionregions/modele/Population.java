package com.MaliTourist.Apigestionregions.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "population")
@Table(name = "population")
@Data
@NoArgsConstructor
public class Population {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int habitant;
    private Long annee;

    @ManyToOne
    private Region region;

}
