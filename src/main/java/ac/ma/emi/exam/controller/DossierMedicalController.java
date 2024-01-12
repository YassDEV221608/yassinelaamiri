package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.DossierMedical;
import ac.ma.emi.exam.repository.DossierMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dossiermedical")
public class DossierMedicalController {
    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;

    @GetMapping("/get")
    public List<DossierMedical> get() {
        return dossierMedicalRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public DossierMedical getById(@PathVariable("id") Long id) {
        return dossierMedicalRepository.findById(id).get();
    }

    @PostMapping("/save")
    public DossierMedical save(@RequestBody DossierMedical dossierMedical) {
        return dossierMedicalRepository.save(dossierMedical);
    }

    @PutMapping("/update/{id}")
    public DossierMedical update(@RequestBody DossierMedical dossierMedical,@PathVariable("id") Long id) {
        Optional<DossierMedical> dossierMedicalDB = dossierMedicalRepository.findById(id);
        if(!dossierMedicalDB.isPresent()) {
            throw new RuntimeException("dossier medical inexistant");
        }
        dossierMedicalDB.get().setNumero(dossierMedical.getNumero());
        dossierMedicalDB.get().setDateCreation(dossierMedical.getDateCreation());
        dossierMedicalDB.get().setCodeAccesPatient(dossierMedical.getCodeAccesPatient());
        dossierMedicalRepository.save(dossierMedicalDB.get());
        return dossierMedicalDB.get();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        dossierMedicalRepository.deleteById(id);
    }

}
