package ac.ma.emi.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int dateCreation;
    private String codeAccesPatient;

    public DossierMedical() {
    }

    public DossierMedical(int numero, int dateCreation, String codeAccesPatient) {
        this.numero = numero;
        this.dateCreation = dateCreation;
        this.codeAccesPatient = codeAccesPatient;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(int dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCodeAccesPatient() {
        return codeAccesPatient;
    }

    public void setCodeAccesPatient(String codeAccesPatient) {
        this.codeAccesPatient = codeAccesPatient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DossierMedical that = (DossierMedical) o;
        return numero == that.numero && dateCreation == that.dateCreation && Objects.equals(id, that.id) && Objects.equals(codeAccesPatient, that.codeAccesPatient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, dateCreation, codeAccesPatient);
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
                "id=" + id +
                ", numero=" + numero +
                ", dateCreation=" + dateCreation +
                ", codeAccesPatient='" + codeAccesPatient + '\'' +
                '}';
    }
}
