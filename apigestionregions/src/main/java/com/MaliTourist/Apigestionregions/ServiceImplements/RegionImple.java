package com.MaliTourist.Apigestionregions.ServiceImplements;

import com.MaliTourist.Apigestionregions.Repository.RegionRepo;
import com.MaliTourist.Apigestionregions.modele.Region;
import com.MaliTourist.Apigestionregions.service.ServiceRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@AllArgsConstructor

// Ceci est notre couche métiers Region
@Service
public class RegionImple implements ServiceRegion {

    // on faire appelle au repository pour les methodes CRUD
    private RegionRepo r_region;

    @Override
    public Region ajouterRegion(Region region) {
        //methode save pour enregistrer notre entité de type region
        return r_region.save(region);
    }

    @Override
    public String supprimerRegion(Long id) {
        r_region.deleteById(id);


        String message = "Région supprimé!";
        return message;
    }

    @Override
    public List<Region> listerRegion() {

        return r_region.findAll();
    }

    @Override
    public Region modifierRegion(Long id, Region region) {

        return r_region.findById(id).map(p->{
            //nous allons modifier chaque champ avec le setter et appeller les rentrer(region) avec le getter qui
            //  sera la nouvelle valeur

            p.setNomregion(region.getNomregion());
            p.setCoderegion (region.getCoderegion ());
            p.setDomaineactivite(region.getDomaineactivite());
            p.setLangue(region.getLangue());
            p.setSuperficie(region.getSuperficie());

            //ça retourne le resultat save p au lieu de region
            return r_region.save(p);
        }).orElseThrow(()->new RuntimeException("La région non trouvé!"));
    }


 /*   //Cette methode va faire appelle au fonction findByNom_region
    @Override
    public Region getRegionByNom_region(String nom_region) {
        return r_region.findByNom_Region(nom_region);
    }*/


}
