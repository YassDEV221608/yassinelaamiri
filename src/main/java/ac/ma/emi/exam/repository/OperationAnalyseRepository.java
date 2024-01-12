package ac.ma.emi.exam.repository;

import ac.ma.emi.exam.entity.OperationAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationAnalyseRepository extends JpaRepository<OperationAnalyse,Long> {
}
