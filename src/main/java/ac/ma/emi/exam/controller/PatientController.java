package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.Patient;
import ac.ma.emi.exam.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/get")
    public List<Patient> get() {
        return patientRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Patient getById(@PathVariable("id") Long id) {
        return patientRepository.findById(id).get();
    }

    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/update/{id}")
    public Patient update(@RequestBody Patient patient,@PathVariable("id") Long id) {
        Optional<Patient> patientDB = patientRepository.findById(id);
        if(!patientDB.isPresent()) {
            throw new RuntimeException("Patient existant");
        }
        patientDB.get().setnSS(patient.getnSS());
        patientDB.get().setPrenom(patient.getPrenom());
        patientDB.get().setNom(patient.getNom());
        patientDB.get().setDateNaissance(patient.getDateNaissance());
        patientDB.get().setSexe(patient.getSexe());
        patientDB.get().setAdresse(patient.getAdresse());
        patientDB.get().setNumTelephone(patient.getNumTelephone());

        patientRepository.save(patientDB.get());
        return patientDB.get();
    }
}
