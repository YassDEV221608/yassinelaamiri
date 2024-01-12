package ac.ma.emi.exam.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nSS;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private char sexe;
    private String adresse;
    private int numTelephone;

    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private DossierMedical dossierMedical;

    public Patient() {
    }

    public Patient(String nSS, String prenom, String nom, Date dateNaissance, char sexe, String adresse, int numTelephone,DossierMedical dossierMedical) {
        this.nSS = nSS;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.numTelephone = numTelephone;
        this.dossierMedical = dossierMedical;
    }

    public String getnSS() {
        return nSS;
    }

    public void setnSS(String nSS) {
        this.nSS = nSS;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return sexe == patient.sexe && numTelephone == patient.numTelephone && Objects.equals(id, patient.id) && Objects.equals(nSS, patient.nSS) && Objects.equals(prenom, patient.prenom) && Objects.equals(nom, patient.nom) && Objects.equals(dateNaissance, patient.dateNaissance) && Objects.equals(adresse, patient.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nSS, prenom, nom, dateNaissance, sexe, adresse, numTelephone);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nSS='" + nSS + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", sexe=" + sexe +
                ", adresse='" + adresse + '\'' +
                ", numTelephone=" + numTelephone +
                '}';
    }
}
