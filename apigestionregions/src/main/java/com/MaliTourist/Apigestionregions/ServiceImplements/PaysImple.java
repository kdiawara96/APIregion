package com.MaliTourist.Apigestionregions.ServiceImplements;

import com.MaliTourist.Apigestionregions.Repository.PaysRepo;
import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.service.ServicePays;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@AllArgsConstructor

// Ceci est notre couche métiers Region
@Service
public class PaysImple implements ServicePays {

 private PaysRepo r_pays;


    //pays


    @Override
    public Pays ajouterPays(Pays pays) {
        return r_pays.save(pays);
    }

    @Override
    public Pays modifierPays(Long id, Pays pays) {
        r_pays.findById(id).map(p->{
                    p.setNomPays(pays.getNomPays());
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


    @Override
    public Pays getNomPays(Pays pays) {
        return r_pays.findByNomPays(pays.getNomPays());
    }

}
