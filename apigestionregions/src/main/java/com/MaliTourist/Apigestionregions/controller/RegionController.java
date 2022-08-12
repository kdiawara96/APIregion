package com.MaliTourist.Apigestionregions.controller;


import com.MaliTourist.Apigestionregions.modele.Region;
import com.MaliTourist.Apigestionregions.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //pour designer que ces notre controller Region en Spring boot
@RequestMapping("/region") //notre chemain pour que ça soit accecible  http:localhost:8080/produit

@AllArgsConstructor

public class RegionController {

    private final RegionService region_S;

    @PostMapping("/ajouterRegion")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Region ajouterRegion(@RequestBody Region region){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        return region_S.ajouterRegion(region);
    }

    @GetMapping("/listerRegion")
    public List<Region> ListerRegion(){

        return region_S.listerRegion();
    }
    @PutMapping("/modifierRegion/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

 public Region modifierRegion(@PathVariable Long id, @RequestBody Region region){

        //on fait appelle au methode modifierRegion de la classe RegionServiceImpl
        return region_S.modifierRegion(id,region);
 }

 @DeleteMapping("/supprimerRegion/{id}") //

 public String supprimerRegion(@PathVariable Long id){
        return region_S.supprimerRegion(id);
 }

}
