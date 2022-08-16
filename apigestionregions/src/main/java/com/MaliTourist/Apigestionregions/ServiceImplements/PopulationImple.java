package com.MaliTourist.Apigestionregions.ServiceImplements;

import com.MaliTourist.Apigestionregions.Repository.PopulationRepo;
import com.MaliTourist.Apigestionregions.modele.Population;
import com.MaliTourist.Apigestionregions.service.ServicePopulation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@AllArgsConstructor

// Ceci est notre couche métiers Region
@Service

public class PopulationImple  implements ServicePopulation {

    private PopulationRepo r_population;

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
}
