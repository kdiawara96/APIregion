package com.MaliTourist.Apigestionregions.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "region")
@Table(name = "region")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 26)
    private String code_rg;
    private String nom;
    private String d_act;
    private int superficie;
    private String langue;

    @ManyToOne
    private Pays pays;

   // @OneToMany(mappedBy = "region")
    //private Collection<Population> population;

   
}
