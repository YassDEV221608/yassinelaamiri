package ac.ma.emi.exam.repository;

import ac.ma.emi.exam.entity.FicheConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheConsulationRepository extends JpaRepository<FicheConsultation,Long> {
}
