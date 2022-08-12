package com.MaliTourist.Apigestionregions.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "population")
@Data
@NoArgsConstructor
public class Population {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int population;
    private Date annee;

}
