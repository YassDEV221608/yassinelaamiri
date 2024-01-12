package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.FicheDeSion;
import ac.ma.emi.exam.repository.FicheDeSionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fichedesion")
public class FicheDeSoinCntroller {
    @Autowired
    private FicheDeSionRepository ficheDeSionRepository;

    @GetMapping("/get")
    public List<FicheDeSion> get() {
        return ficheDeSionRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public FicheDeSion getById(@PathVariable("id") Long id) {
        return ficheDeSionRepository.findById(id).get();
    }

    @PostMapping("/save")
    public FicheDeSion save(@RequestBody FicheDeSion ficheDeSion) {
        return ficheDeSionRepository.save(ficheDeSion);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        ficheDeSionRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public FicheDeSion update(@RequestBody FicheDeSion ficheDeSion,@PathVariable("id") Long id) {
        Optional<FicheDeSion> ficheDeSionDB = ficheDeSionRepository.findById(id);
        if(!ficheDeSionDB.isPresent()) {
            throw new RuntimeException("Fiche de sion inexistante");
        }
        ficheDeSionDB.get().setNumeroFiche(ficheDeSion.getNumeroFiche());
        ficheDeSionDB.get().setDateCreation(ficheDeSion.getDateCreation());
        ficheDeSionDB.get().setAgentCreateur(ficheDeSion.getAgentCreateur());
        ficheDeSionDB.get().setAdressCreateur(ficheDeSion.getAdressCreateur());
        ficheDeSionDB.get().setFicheDeSions(ficheDeSion.getFicheDeSions());

        ficheDeSionRepository.save(ficheDeSionDB.get());
        return ficheDeSionDB.get();
    }
}
