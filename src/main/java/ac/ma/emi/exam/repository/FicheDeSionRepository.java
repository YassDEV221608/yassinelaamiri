package ac.ma.emi.exam.repository;

import ac.ma.emi.exam.entity.FicheDeSion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheDeSionRepository extends JpaRepository<FicheDeSion,Long> {
}
