package com.MaliTourist.Apigestionregions.controller;

import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.others.MessageError;
import com.MaliTourist.Apigestionregions.service.ServicePays;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //pour designer que ces notre controller Region en Spring boot
@RequestMapping("/apirest") //notre chemain pour que ça soit accecible  http:localhost:8080/produit
@AllArgsConstructor
@Api(value = "api", description = "Une API de GESTION des REGIONS pour faciliter a l'agence de touristes")


public class PaysController {
  private ServicePays pay;

    //pays
    @ApiOperation(value = "Cette methode va vous permettre d'AJOUTER un Pays!")
    //postMapping permet de poster les données avec le mappage /ajouterPays
    @PostMapping("/addPays")
    // pour que spring envoie des données au niveau du body de la requet on utilise @RequestBody

    public Object ajouterPays(@RequestBody Pays pays){

     try {
        return pay.ajouterPays(pays);
      }catch (Exception e){
        return MessageError.ErrorResponse("Ce Pays existe deja", HttpStatus.OK, null);
      }
    }

    //getMapping nous permet de lister les pays grace au get qui nous permet de recuperer la liste
    @ApiOperation(value = "Cette methode va vous permettre de LISTER les PAYS!")
    @GetMapping("/listPays")
    public List<Pays> ListerPays(Pays pays){

        return pay.listerPays();
    }

    @ApiOperation(value = "Cette methode va vous permettre de LISTER un PAYS!")
    @PutMapping("/updatePays/{id}")
    // nous allons prendre PutMapping avec le chemain et l'id
    //on envoie ?name=xx login// xxxxx
    //PathVariable est la variable qui va être entrer dans le url

    public Pays modifierPays(@PathVariable Long id, @RequestBody Pays pays){
        //on fait appelle au methode modifierRegion de la classe PopulationServiceImpl
        return pay.modifierPays(id,pays);
    }


    @ApiOperation(value = "Cette methode va vous permettre de SUPPRIMER un PAYS!")
    @DeleteMapping("/deletePays/{id}")


    public String supprimerPays(@PathVariable Long id){
        return pay.supprimerPays(id);
    }
}
