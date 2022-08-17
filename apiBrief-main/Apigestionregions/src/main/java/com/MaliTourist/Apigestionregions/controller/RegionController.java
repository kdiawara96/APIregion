package com.MaliTourist.Apigestionregions.controller;


import com.MaliTourist.Apigestionregions.modele.Pays;
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
@RequestMapping("/region") //notre chemain pour que ça soit accecible  http:localhost:8080/produit
@AllArgsConstructor
@Api(value = "api", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")

public class RegionController {

    //on fait appelle a l'interface Service region

    private ServiceRegion reg;
    private ServicePays r_pays;
    private ServicePopulation pop;


    //Region

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER les REGIONS")

    @PostMapping("/add")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Region ajouterRegion(@RequestBody Region region){

        //on faire appelle au methode ajouter dans RegionServiceImpl
        return reg.ajouterRegion(region);
    }
    @ApiOperation(value = "Cette methode va vous permettre de LISTER les REGIONS")
    @GetMapping("/list")
    public List<Region> ListerRegion(){

        return reg.listerRegion();
    }


    @ApiOperation(value = "Cette methode va vous permettre de MODIFIER les REGIONS")
    @PutMapping("/update/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

    public Region modifierRegion(@PathVariable Long id, @RequestBody Region region){

        //on fait appelle au methode modifierRegion de la classe RegionServiceImpl
        return reg.modifierRegion(id,region);
    }

    @ApiOperation(value = "Cette methode va vous permettre de SUPPRIMER les REGIONS")
    @DeleteMapping("/delete/{id}") //

    public String deleteRegion(@PathVariable Long id){

        return reg.supprimerRegion(id);
    }

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la region ainsi que le Pays dans un même formulaire si le pays n'existe pas")
    @PostMapping("/addRegionPays")
    public Region ajouterRegionPopulation(@RequestBody Region region) {

        //Region RegionNameisPresente = reg.getRegionByNom_region(region.getNom_region());

        Pays PaysNameisPresente = r_pays.getNompays(region.getPays());

        if(PaysNameisPresente == null ){
            r_pays.ajouterPays(region.getPays());

     }
        return reg.ajouterRegion(region);
    }
    /*
************************************************

    //Ajouter la region ainsi que la population en même temps

    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER la region ainsi que la POPULATION dans un même formulaire")
    @PostMapping("/ajouterRegionPopulation")
    public void ajouterRegionPopulation(@RequestBody Region region, @RequestBody Population population, @RequestBody HttpServletResponse response ) throws IOException {



        reg.ajouterRegion(region);
        pop.ajouterPopulation(population);

        response.setHeader("Custom-Header", "fooAZZZZZZZZZZREAA");
        response.setStatus(400);
        response.getWriter().println("Hello World!AAAAGHGA");

    }



@PostMapping("/manual")
    void manual(HttpServletResponse response) throws IOException {
        response.setHeader("Custom-Header", "fooAZZZZZZZZZZREAA");
        response.setStatus(200);
        response.getWriter().println("Hello Worlgyqsigxqskusd!AAAAGHGA");
    }*/

}
