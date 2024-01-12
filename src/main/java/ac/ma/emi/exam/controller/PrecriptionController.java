package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.Prescription;
import ac.ma.emi.exam.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/prescription")
public class PrecriptionController {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/get")
    public List<Prescription> get() {
        return prescriptionRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Prescription getById(@PathVariable("id") Long id) {
        return prescriptionRepository.findById(id).get();
    }

    @PostMapping("/save")
    public Prescription save(@RequestBody Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @PutMapping("/update/{id}")
    public Prescription update(@RequestBody Prescription prescription,@PathVariable("id") Long id) {
        Optional<Prescription> prescriptionDB = prescriptionRepository.findById(id);
        if(!prescriptionDB.isPresent()) {
            throw new RuntimeException("Prescription inexistante");
        }
        prescriptionDB.get().setDesignation(prescription.getDesignation());
        prescriptionDB.get().setIndication(prescription.getIndication());
        prescriptionDB.get().setDesignation(prescription.getDesignation());
        prescriptionRepository.save(prescriptionDB.get());
        return prescriptionDB.get();
    }
}
