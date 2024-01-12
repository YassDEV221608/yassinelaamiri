package ac.ma.emi.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class FichePayement extends FicheDeSion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateExibilite;
    private Date datePayement;
    private double montantPaye;
    private boolean indicateurPayement;

    public FichePayement() {
    }

    public FichePayement(int numeroFiche, Date dateCreation, String agentCreateur, String adressCreateur, FicheDeSion ficheDeSions, Date dateExibilite, Date datePayement, double montantPaye, boolean indicateurPayement,DossierMedical dossierMedical) {
        super(numeroFiche, dateCreation, agentCreateur, adressCreateur, ficheDeSions,dossierMedical);
        this.dateExibilite = dateExibilite;
        this.datePayement = datePayement;
        this.montantPaye = montantPaye;
        this.indicateurPayement = indicateurPayement;
    }

    public Date getDateExibilite() {
        return dateExibilite;
    }

    public void setDateExibilite(Date dateExibilite) {
        this.dateExibilite = dateExibilite;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public boolean isIndicateurPayement() {
        return indicateurPayement;
    }

    public void setIndicateurPayement(boolean indicateurPayement) {
        this.indicateurPayement = indicateurPayement;
    }

    @Override
    public String toString() {
        return "FichePayement{" +
                "id=" + id +
                ", dateExibilite=" + dateExibilite +
                ", datePayement=" + datePayement +
                ", montantPaye=" + montantPaye +
                ", indicateurPayement=" + indicateurPayement +
                '}';
    }
}
