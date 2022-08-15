package com.MaliTourist.Apigestionregions.service;

import com.MaliTourist.Apigestionregions.Repository.PaysRepo;
import com.MaliTourist.Apigestionregions.Repository.PopulationRepo;
import com.MaliTourist.Apigestionregions.Repository.RegionRepo;
import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.modele.Population;
import com.MaliTourist.Apigestionregions.modele.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor

// Ceci est notre couche métiers Region
@Service
public class ServicesImpl implements Services {

    // on faire appelle au repository pour les methodes CRUD
    private RegionRepo r_region;
    private PopulationRepo r_population;
    private PaysRepo r_pays;



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

            p.setNom(region.getNom());
            p.setCode_rg(region.getCode_rg());
            p.setD_act(region.getD_act());
            p.setLangue(region.getLangue());
            p.setSuperficie(region.getSuperficie());

            //ça retourne le resultat save p au lieu de region
            return r_region.save(p);
        }).orElseThrow(()->new RuntimeException("La région non trouvé!"));
    }


    //population




    @Override
    public Population modifierPopulation(Long id, Population population) {
        return r_population.findById(id).map(p->{
            p.setHabitant(population.getHabitant());
            p.setAnnee(population.getAnnee());

            return r_population.save(p);
        }).orElseThrow(()-> new RuntimeException("Population modifier avec succes!"));
    }

    @Override
    public String supprimerPopulation(Long id) {

        r_population.findById(id);

        String message ="Population supprimer avec succes !";
        return message;
    }

    @Override
    public List<Population> listerPopulation() {
        return r_population.findAll();
    }

    @Override
    public Population ajouterPopulation(Population population) {

        return r_population.save(population);
    }

    //pays


    @Override
    public Pays ajouterPays(Pays pays) {
        return r_pays.save(pays);
    }

    @Override
    public Pays modifierPays(Long id, Pays pays) {
        r_pays.findById(id).map(p->{
                    p.setNom_pays(pays.getNom_pays());
                    return r_pays.save(p);
                }
        ).orElseThrow(()->new RuntimeException("Pays modifier!"));
        return null;
    }

    @Override
    public String supprimerPays(Long id) {
        r_pays.findById(id);
        return "Pays Supprimer avec succes!";

    }

    @Override
    public List<Pays> listerPays() {

        return r_pays.findAll();
    }



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


}
