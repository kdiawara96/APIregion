package com.MaliTourist.Apigestionregions.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "population")
@Table(name = "population")
@Data
@NoArgsConstructor
public class Population {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="habitant",length = 12, nullable = false)
    private int habitant;
    @Column(name="annee", nullable = false)
    private Date annee;

   @ManyToOne
    private Region region;

}
