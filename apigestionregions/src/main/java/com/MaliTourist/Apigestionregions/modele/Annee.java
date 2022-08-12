package com.MaliTourist.Apigestionregions.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table

public class Annee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date annee;
}
