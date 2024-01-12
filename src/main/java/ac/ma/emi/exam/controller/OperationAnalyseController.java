package ac.ma.emi.exam.controller;

import ac.ma.emi.exam.entity.OperationAnalyse;
import ac.ma.emi.exam.repository.OperationAnalyseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/operationanalyse")
public class OperationAnalyseController {
    @Autowired
    private OperationAnalyseRepository operationAnalyseRepository;

    @GetMapping("/get")
    public List<OperationAnalyse> get() {
        return operationAnalyseRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public OperationAnalyse get(@PathVariable("id") Long id) {
        return operationAnalyseRepository.findById(id).get();
    }

    @PostMapping("/save")
    public OperationAnalyse save(@RequestBody OperationAnalyse operationAnalyse) {
        return operationAnalyseRepository.save(operationAnalyse);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        operationAnalyseRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public OperationAnalyse update(@RequestBody OperationAnalyse operationAnalyse,@PathVariable("id") Long id) {
        Optional<OperationAnalyse> operationAnalyseDB = operationAnalyseRepository.findById(id);
        if(!operationAnalyseDB.isPresent()) {
            throw new RuntimeException("Operation d'analyse inexistante");
        }
        operationAnalyseDB.get().setDateheureOperation(operationAnalyse.getDateheureOperation());
        operationAnalyseDB.get().setDescription(operationAnalyse.getDescription());
        operationAnalyseDB.get().setResultat(operationAnalyse.getResultat());
        operationAnalyseRepository.save(operationAnalyseDB.get());
        return operationAnalyseDB.get();
    }
}
