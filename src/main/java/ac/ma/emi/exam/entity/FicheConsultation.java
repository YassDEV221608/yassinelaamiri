package ac.ma.emi.exam.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class FicheConsultation extends FicheDeSion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String compteRendu;

    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id",nullable = false)
    private Consultation consultation;

    @OneToMany
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<OperationAnalyse> operationAnalyses;

    @OneToMany
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<Prescription> prescriptions = new ArrayList<>();

    public FicheConsultation() {
        prescriptions.add(new Prescription());
    }

    public FicheConsultation(int numeroFiche, Date dateCreation, String agentCreateur, String adressCreateur, FicheDeSion ficheDeSions, String compteRendu,Consultation consultation,DossierMedical dossierMedical) {
        super(numeroFiche, dateCreation, agentCreateur, adressCreateur, ficheDeSions,dossierMedical);
        this.compteRendu = compteRendu;
        this.consultation = consultation;
        prescriptions.add(new Prescription());
    }

    public void addPrescription(Prescription prescription) {
        if(prescriptions == null) {
            prescriptions = new ArrayList<>();
        }
        prescriptions.add(prescription);
    }

    public void removePrescription(Prescription prescription) {
        int index = prescriptions.indexOf(prescription);
        prescriptions.remove(index);
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<OperationAnalyse> getOperationAnalyses() {
        return operationAnalyses;
    }

    public void setOperationAnalyses(List<OperationAnalyse> operationAnalyses) {
        this.operationAnalyses = operationAnalyses;
    }

    public void addOperationAnalyse(OperationAnalyse operationAnalyse) {
        if(operationAnalyses == null) {
            operationAnalyses = new ArrayList<>();
        }
        operationAnalyses.add(operationAnalyse);
    }

    public void removeOperationAnalyse(OperationAnalyse operationAnalyse) {
        int index = operationAnalyses.indexOf(operationAnalyse);
        operationAnalyses.remove(index);
    }

    public FicheConsultation(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheConsultation that = (FicheConsultation) o;
        return Objects.equals(id, that.id) && Objects.equals(compteRendu, that.compteRendu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compteRendu);
    }

    @Override
    public String toString() {
        return "FicheConsultation{" +
                "id=" + id +
                ", compteRendu='" + compteRendu + '\'' +
                '}';
    }
}
