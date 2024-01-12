package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.Consultation;
import ac.ma.emi.exam.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationRepository consultationRepository;

    @GetMapping("/get")
    public List<Consultation> get() {
        return consultationRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Consultation getById(@PathVariable("id") Long id) {
        return consultationRepository.findById(id).get();
    }

    @PostMapping("/save")
    public Consultation save(@RequestBody Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @PutMapping("/update/{id}")
    public Consultation update(@PathVariable("id") Long id,@RequestBody Consultation consultation) {
        Optional<Consultation> consultationDB = consultationRepository.findById(id);
        if(!consultationDB.isPresent()) {
            throw new RuntimeException("Consultation inexistante");
        }
        consultationDB.get().setDateConsultation(consultation.getDateConsultation());
        consultationDB.get().setHeure(consultation.getHeure());
        consultationDB.get().setLieu(consultation.getLieu());
        consultationDB.get().setEtatConsult(consultation.getEtatConsult());
        consultationRepository.save(consultationDB.get());
        return consultationDB.get();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        consultationRepository.deleteById(id);
    }
}
