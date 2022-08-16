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

    @Column(name="nom_region",length = 25,unique = true)
    private String nomRegion;

    @Column( name="codeRegion",length = 10, unique = true, nullable = false)
    private String codeRegion;

    @Column(length = 50)
    private String domaineActivite;
    @Column(length = 50)
    private String superficie;
    @Column(length = 50)
    private String langue;

    @ManyToOne
    private Pays pays;


    //@OneToMany(mappedBy = "region")
  // private Collection<Population> population;

   
}
