package ac.ma.emi.exam.controller;



import ac.ma.emi.exam.entity.FichePayement;
import ac.ma.emi.exam.repository.FichePayementPrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fichepayment")
public class FichePaymentController {
    @Autowired
    private FichePayementPrepository fichePayementPrepository;

    @GetMapping("/get")
    public List<FichePayement> get() {
        return fichePayementPrepository.findAll();
    }

    @GetMapping("/get/{id}")
    public FichePayement getById(@PathVariable("id") Long id) {
        return fichePayementPrepository.findById(id).get();
    }

    @PostMapping("/save")
    public FichePayement save(@RequestBody FichePayement fichePayement) {
        return fichePayementPrepository.save(fichePayement);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        fichePayementPrepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public FichePayement update(@RequestBody FichePayement fichePayement,@PathVariable("id") Long id) {
        Optional<FichePayement> fichePayementDB = fichePayementPrepository.findById(id);
        if(!fichePayementDB.isPresent()) {
            throw new RuntimeException("Fiche payment inexistante");
        }
        fichePayementDB.get().setNumeroFiche(fichePayement.getNumeroFiche());
        fichePayementDB.get().setDateCreation(fichePayement.getDateCreation());
        fichePayementDB.get().setIndicateurPayement(fichePayement.isIndicateurPayement());
        fichePayementDB.get().setDateExibilite(fichePayement.getDateExibilite());
        fichePayementDB.get().setDatePayement(fichePayement.getDatePayement());
        fichePayementDB.get().setMontantPaye(fichePayement.getMontantPaye());
        fichePayementDB.get().setAgentCreateur(fichePayement.getAgentCreateur());
        fichePayementDB.get().setAdressCreateur(fichePayement.getAdressCreateur());

        fichePayementPrepository.save(fichePayementDB.get());
        return fichePayementDB.get();
    }
}
