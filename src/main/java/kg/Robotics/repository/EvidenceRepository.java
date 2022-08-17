package kg.Robotics.repository;

import kg.Robotics.dao.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence,Long> {

    List<Evidence> findAllByToken(String token);
}
