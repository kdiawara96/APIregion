package com.MaliTourist.Apigestionregions.controller;

import com.MaliTourist.Apigestionregions.modele.Population;
import com.MaliTourist.Apigestionregions.service.ServicePopulation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //pour designer que ces notre controller Region en Spring boot
@RequestMapping("/apirest") //notre chemain pour que ça soit accecible  http:localhost:8080/produit
@AllArgsConstructor
@Api(value = "api", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")


public class PopulationController {

    private ServicePopulation popu;

    //Population

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la POPULATION")
    @PostMapping("/ajouterPopulation")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Population ajouterPopulation(@RequestBody Population population){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        return popu.ajouterPopulation(population);
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER la POPULATION")
    @GetMapping("/listerPopulation")
    public List<Population> ListerPopulation(){

        return popu.listerPopulation();
    }



    @ApiOperation(value = "Cette methode va vous permettre de MODIFIER la POPULATION")
    @PutMapping("/modifierPopulation/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

    public Population modifierPopulation(@PathVariable Long id, @RequestBody Population population){

        //on fait appelle au methode modifierRegion de la classe PopulationServiceImpl
        return popu.modifierPopulation(id,population);
    }


    @ApiOperation(value = "Cette methode va vous permettre de supprimer une POPULATION!")
    @DeleteMapping("/supprimerPopulation/{id}") //

    public String supprimerPopulation(@PathVariable Long id){

        return popu.supprimerPopulation(id);
    }
}
