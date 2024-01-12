package ac.ma.emi.exam.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FicheDeSion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroFiche;
    private Date dateCreation;
    private String agentCreateur;
    private String adressCreateur;

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id",insertable = false,updatable = false)
    private FicheDeSion ficheDeSions;


    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id",insertable = false,updatable = false)
    private DossierMedical dossierMedical;

    public FicheDeSion() {
    }

    public FicheDeSion(int numeroFiche, Date dateCreation, String agentCreateur, String adressCreateur,FicheDeSion ficheDeSions,DossierMedical dossierMedical) {
        this.numeroFiche = numeroFiche;
        this.dateCreation = dateCreation;
        this.agentCreateur = agentCreateur;
        this.adressCreateur = adressCreateur;
        this.ficheDeSions = ficheDeSions;
        this.dossierMedical = dossierMedical;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public FicheDeSion getFicheDeSions() {
        return ficheDeSions;
    }

    public void setFicheDeSions(FicheDeSion ficheDeSions) {
        this.ficheDeSions = ficheDeSions;
    }

    public int getNumeroFiche() {
        return numeroFiche;
    }

    public void setNumeroFiche(int numeroFiche) {
        this.numeroFiche = numeroFiche;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAgentCreateur() {
        return agentCreateur;
    }

    public void setAgentCreateur(String agentCreateur) {
        this.agentCreateur = agentCreateur;
    }

    public String getAdressCreateur() {
        return adressCreateur;
    }

    public void setAdressCreateur(String adressCreateur) {
        this.adressCreateur = adressCreateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheDeSion that = (FicheDeSion) o;
        return numeroFiche == that.numeroFiche && Objects.equals(id, that.id) && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(agentCreateur, that.agentCreateur) && Objects.equals(adressCreateur, that.adressCreateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroFiche, dateCreation, agentCreateur, adressCreateur);
    }

    @Override
    public String toString() {
        return "FicheDeSion{" +
                "id=" + id +
                ", numeroFiche=" + numeroFiche +
                ", dateCreation=" + dateCreation +
                ", agentCreateur='" + agentCreateur + '\'' +
                ", adressCreateur='" + adressCreateur + '\'' +
                '}';
    }
}
