package com.MaliTourist.Apigestionregions.controller;


import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.modele.Population;
import com.MaliTourist.Apigestionregions.modele.Region;
import com.MaliTourist.Apigestionregions.service.Services;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //pour designer que ces notre controller Region en Spring boot
@RequestMapping("/apirest") //notre chemain pour que ça soit accecible  http:localhost:8080/produit
@AllArgsConstructor
@Api(value = "api", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")

public class Controllers {

    private final Services service;

// String message = "Cette methode va vous permettre";
    //Region

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER les REGIONS")

    @PostMapping("/ajouterRegion")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Region ajouterRegion(@RequestBody Region region){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        return service.ajouterRegion(region);
    }
    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS")
    @GetMapping("/listerRegion")
    public List<Region> ListerRegion(){

        return service.listerRegion();
    }


    @ApiOperation(value = "Cette methode va vous permettre de MODIFIER les REGIONS")
    @PutMapping("/modifierRegion/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

 public Region modifierRegion(@PathVariable Long id, @RequestBody Region region){

        //on fait appelle au methode modifierRegion de la classe RegionServiceImpl
        return service.modifierRegion(id,region);
 }

    @ApiOperation(value = "Cette methode va vous permettre de SUPPRIMER les REGIONS")
   @DeleteMapping("/supprimerRegion/{id}") //

 public String supprimerRegion(@PathVariable Long id){

        return service.supprimerRegion(id);
 }


 //Population

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la POPULATION")
    @PostMapping("/ajouterPopulation")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Population ajouterPopulation(@RequestBody Population population){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        return service.ajouterPopulation(population);
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER la POPULATION")
    @GetMapping("/listerPopulation")
    public List<Population> ListerPopulation(){

        return service.listerPopulation();
    }



    @ApiOperation(value = "Cette methode va vous permettre de MODIFIER la POPULATION")
    @PutMapping("/modifierPopulation/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

    public Population modifierPopulation(@PathVariable Long id, @RequestBody Population population){

        //on fait appelle au methode modifierRegion de la classe PopulationServiceImpl
        return service.modifierPopulation(id,population);
    }


    @ApiOperation(value = "Cette methode va vous permettre de supprimer une POPULATION!")
    @DeleteMapping("/supprimerPopulation/{id}") //

    public String supprimerPopulation(@PathVariable Long id){

        return service.supprimerPopulation(id);
    }

    //pays

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER un Pays!")
    //postMapping permet de poster les données avec le mappage /ajouterPays
    @PostMapping("/ajouterPays")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Pays ajouterPays(@RequestBody Pays pays){
        return service.ajouterPays(pays);
    }

//getMapping nous permet de lister les pays grace au get qui nous permet de recuperer la liste
@ApiOperation(value = "Cette methode va vous permettre de LISTER les PAYS!")
    @GetMapping("/listerPays")
    public List<Pays> ListerPays(Pays pays){

        return service.listerPays();
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER un PAYS!")
    @PutMapping("/modifierPays/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

    public Pays modifierPays(@PathVariable Long id, @RequestBody Pays pays){
        //on fait appelle au methode modifierRegion de la classe PopulationServiceImpl
        return service.modifierPays(id,pays);
    }


    @ApiOperation(value = "Cette methode va vous permettre de SUPPRIMER un PAYS!")
    @DeleteMapping("/supprimerPays/{id}")

    public String supprimerPays(@PathVariable Long id){
        return service.supprimerPays(id);
    }




    //query natif lister region sans pays
    @ApiOperation(value = "Cette methode va vous permettre de LISTER LES REGIONS SANS UN PAYS!")
    @GetMapping("/listeRegionSansPays")
    public Iterable<Object[]> listeRegionSansPays() {
        return service.listeRegionSansPays();
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS AVEC PAYS!")
    @GetMapping("/listeRegionAvecPays")
    public Iterable<Object[]> listeRegion(){
        return service.listeRegionAvecPays();
   }
    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS PAR PAYS!")
    @GetMapping("/listeRegionParPays/{pays}")

    public Iterable<Object[]> listeRegionParPays(@PathVariable String pays){
        return service.listeRegionParPays(pays);
   }

   //Lister la population et l'annee

    @ApiOperation(value = "Cette methode va vous permettre de LISTER la POPULATION, l'ANNEEA pour chaque REGIONS!")
    @GetMapping("/populationParAnnee/{region}")

    public Iterable<Object[]> listePopulationAnneeParRegion(@PathVariable String region){
        return service.listePopulationAnneeParRegion(region);
    }



    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS PAR PAYS!")
    @GetMapping("/PaysRegionHabitantAnneee/{pays}")

    public Iterable<Object[]> liste_pays_region_population(@PathVariable String pays){
        return service.liste_pays_region_population(pays);
    }
}
