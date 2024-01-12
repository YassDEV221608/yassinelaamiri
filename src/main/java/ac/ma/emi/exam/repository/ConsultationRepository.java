package ac.ma.emi.exam.repository;

import ac.ma.emi.exam.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
