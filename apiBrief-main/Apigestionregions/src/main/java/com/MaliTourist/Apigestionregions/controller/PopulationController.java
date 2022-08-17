package com.MaliTourist.Apigestionregions.controller;

import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.modele.Population;
import com.MaliTourist.Apigestionregions.modele.Region;
import com.MaliTourist.Apigestionregions.service.ServicePays;
import com.MaliTourist.Apigestionregions.service.ServicePopulation;
import com.MaliTourist.Apigestionregions.service.ServiceRegion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //pour designer que ces notre controller Region en Spring boot
@RequestMapping("/population") //notre chemain pour que ça soit accecible  http:localhost:8080/produit
@AllArgsConstructor
@Api(value = "api", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")


public class PopulationController {

    private ServicePopulation popu;
    private ServicePays pay;
    private ServiceRegion reg;

    //Population

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la POPULATION")
    @PostMapping("/add")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Population ajouterPopulation(@RequestBody Population population){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        return popu.ajouterPopulation(population);
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER la POPULATION")
    @GetMapping("/list")
    public List<Population> ListerPopulation(){

        return popu.listerPopulation();
    }



    @ApiOperation(value = "Cette methode va vous permettre de MODIFIER la POPULATION")
    @PutMapping("/update/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

    public Population modifierPopulation(@PathVariable Long id, @RequestBody Population population){

        //on fait appelle au methode modifierRegion de la classe PopulationServiceImpl
        return popu.modifierPopulation(id,population);
    }


    @ApiOperation(value = "Cette methode va vous permettre de supprimer une POPULATION!")
    @DeleteMapping("/delete/{id}") //

    public String supprimerPopulation(@PathVariable Long id){

        return popu.supprimerPopulation(id);
    }


/*
    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la POPULATION, la region, le pays")
    @PostMapping("/addPopulationRegionPays")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Population addPopulation_region_pays(@RequestBody Population population,@RequestBody Region region){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        Region RegionNameisPresente = reg.getNomregion(population.getRegion());

        if (RegionNameisPresente == null){
            reg.ajouterRegion(population.getRegion());
        }
        Pays PaysNameisPresente = pay.getNompays(region.getPays());

        if (PaysNameisPresente == null){
            //pay.ajouterPays(region.getPays());

        }
        return popu.ajouterPopulation(population);

    }*/

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la POPULATION, la region!")
    @PostMapping("/addPopulationRegion")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Population addPopulation_region_pays( Population population, Region region) {

        //on faire appelle au methode ajouter dans RegionServiceImpl
        Region RegionNameisPresente = reg.getNomregion(population.getRegion());

        if (RegionNameisPresente == null) {
            reg.ajouterRegion(population.getRegion());
        }


      Pays PaysNameisPresente = pay.getNompays(region.getPays());

        if (PaysNameisPresente == null){
            pay.ajouterPays(region.getPays());

        }

        return popu.ajouterPopulation(population);
    }
}
