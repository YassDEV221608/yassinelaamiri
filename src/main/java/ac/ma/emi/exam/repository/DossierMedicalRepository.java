package ac.ma.emi.exam.repository;

import ac.ma.emi.exam.entity.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Long> {
}
