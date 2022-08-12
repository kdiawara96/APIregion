package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.Repository.RegionRepo;
import com.MaliTourist.Apigestionregions.modele.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor

// Ceci est notre couche métiers Region
@Service
public class RegionServiceImpl implements RegionService{
    // on faire appelle au repository pour les methodes CRUD
    private RegionRepo r_repo;

    @Override
    public Region ajouterRegion(Region region) {

        //methode save pour enregistrer notre entité de type region
        return r_repo.save(region);
    }

    @Override
    public String supprimerRegion(Long id) {
       r_repo.deleteById(id);

       String message = "Région supprimé!";
        return message;
    }

    @Override
    public List<Region> listerRegion() {
        return r_repo.findAll();
    }

    @Override
    public Region modifierRegion(Long id, Region region) {
        return r_repo.findById(id).map(p->{
            //nous allons modifier chaque champ avec le setter et appeller les rentrer(region) avec le getter qui
            //  sera la nouvelle valeur

            p.setNom(region.getNom());
            p.setCode_rg(region.getCode_rg());
            p.setD_act(region.getD_act());
            p.setLangue(region.getLangue());
            p.setSuperficie(region.getSuperficie());

            //ça retourne le resultat save p au lieu de region
            return r_repo.save(p);
        }).orElseThrow(()->new RuntimeException("La région non trouvé!"));
    }
}
