package ac.ma.emi.exam.repository;

import ac.ma.emi.exam.entity.FichePayement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichePayementPrepository extends JpaRepository<FichePayement,Long> {
}
