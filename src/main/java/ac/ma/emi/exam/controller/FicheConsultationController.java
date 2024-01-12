package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.FicheConsultation;
import ac.ma.emi.exam.repository.FicheConsulationRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fichedeconsultation")
public class FicheConsultationController {
    @Autowired
    private FicheConsulationRepository ficheConsulationRepository;

    @GetMapping("/get")
    public List<FicheConsultation> get() {
        return ficheConsulationRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public FicheConsultation getById(@PathVariable("id") Long id) {
        return ficheConsulationRepository.findById(id).get();
    }

    @PostMapping("/save")
    public FicheConsultation save(@RequestBody FicheConsultation ficheConsultation) {
        return ficheConsulationRepository.save(ficheConsultation);
    }

    @PutMapping("/update/{id}")
    public FicheConsultation update(@RequestBody FicheConsultation ficheConsultation,@PathVariable("id") Long id) {
        Optional<FicheConsultation> ficheConsultationDB = ficheConsulationRepository.findById(id);
        if(!ficheConsultationDB.isPresent()) {
            throw new RuntimeException("Fiche de consultation inexistante");
        }
        ficheConsultationDB.get().setNumeroFiche(ficheConsultation.getNumeroFiche());
        ficheConsultationDB.get().setDateCreation(ficheConsultation.getDateCreation());
        ficheConsultationDB.get().setAgentCreateur(ficheConsultation.getAgentCreateur());
        ficheConsultationDB.get().setAdressCreateur(ficheConsultation.getAdressCreateur());
        ficheConsultationDB.get().setFicheDeSions(ficheConsultation.getFicheDeSions());
        ficheConsultationDB.get().setCompteRendu(ficheConsultation.getCompteRendu());
        ficheConsultationDB.get().setConsultation(ficheConsultation.getConsultation());
        ficheConsulationRepository.save(ficheConsultationDB.get());
        return ficheConsultationDB.get();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        ficheConsulationRepository.deleteById(id);
    }
}
