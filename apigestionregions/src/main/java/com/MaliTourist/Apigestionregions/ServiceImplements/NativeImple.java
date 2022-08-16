package com.MaliTourist.Apigestionregions.ServiceImplements;

import com.MaliTourist.Apigestionregions.Repository.PaysRepo;
import com.MaliTourist.Apigestionregions.Repository.PopulationRepo;
import com.MaliTourist.Apigestionregions.Repository.RegionRepo;
import com.MaliTourist.Apigestionregions.service.ServiceNative;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor

// Ceci est notre couche métiers Region
@Service
public class NativeImple implements ServiceNative {


    // on faire appelle au repository pour les methodes CRUD
    private RegionRepo r_region;
    private PopulationRepo r_population;
    private PaysRepo r_pays;

    //Natif query

    @Override
    public Iterable<Object[]> listeRegionSansPays() {
        return r_region.listeRegionSansPays();
    }

    @Override
    public Iterable<Object[]> listeRegionAvecPays() {
        return r_region.listeRegionAvecPays();
    }

    @Override
    public Iterable<Object[]> listeRegionParPays(String pays) {
        return r_region.listeRegionParPays(pays);
    }


    @Override
    public Iterable<Object[]> listePopulationAnneeParRegion(String region) {
        return r_population.listePopulationAnneeParRegion(region);
    }

    //Afficher le pays, la region, la population, l'habitant et l'année
    @Override
    public Iterable<Object[]> liste_pays_region_population(String pays) {
        return r_pays.liste_pays_region_population(pays);
    }


    //Afficher la region demander par le user
    @Override
    public Iterable<Object[]> afficherRegionAvecParametre(String nom) {
        return r_region.afficherRegionAvecParametre(nom);
    }


}


  /*  @Override
    public Iterable<Object[]> insererRegionPopulation() {
        return r_region.insererRegionPopulation();
    }*/

