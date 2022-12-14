package com.MaliTourist.Apigestionregions.controller;


import com.MaliTourist.Apigestionregions.service.ServiceNative;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //pour designer que ces notre controller Region en Spring boot
@RequestMapping("/apirest") //notre chemain pour que ça soit accecible  http:localhost:8080/produit
@AllArgsConstructor
@Api(value = "api", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")

public class NativeController {

private ServiceNative Nat;

    //query natif lister region sans pays
    @ApiOperation(value = "Cette methode va vous permettre de LISTER LES REGIONS SANS UN PAYS!")
    @GetMapping("/listRegionSansPays")
    public List<Object[]> listeRegionSansPays() {
        return Nat.listeRegionSansPays();
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS AVEC PAYS!")
    @GetMapping("/listRegionAvecPays")
    public List<Object[]> listeAvecRegion(){
        return Nat.listeRegionAvecPays();
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS PAR PAYS!")
    @GetMapping("/listRegionParPays/{pays}")

    public List<Object[]> listeRegionParPays(@PathVariable String pays){
        return Nat.listeRegionParPays(pays);
    }

    //Lister la population et l'annee

    @ApiOperation(value = "Cette methode va vous permettre de LISTER la POPULATION, l'ANNEEA pour chaque REGIONS!")
    @GetMapping("/populationParAnnee/{region}")

    public List<Object[]> listePopulationAnneeParRegion(@PathVariable String region){
        return Nat.listePopulationAnneeParRegion(region);
    }



    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS PAR PAYS!")
    @GetMapping("/PaysRegionHabitantAnneee/{pays}")

    public List<Object[]> liste_pays_region_population(@PathVariable String pays){
        return Nat.liste_pays_region_population(pays);
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS PAR PAYS!")
    @GetMapping("/afficherRegionAvecParametre/{nom}")
    public List<Object[]> afficherRegionAvecParametre(@PathVariable String nom) {
        return Nat.afficherRegionAvecParametre(nom);
    }




}
