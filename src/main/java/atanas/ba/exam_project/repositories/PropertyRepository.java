package atanas.ba.exam_project.repositories;

import atanas.ba.exam_project.models.entities.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    List<PropertyEntity> findAll();

    Optional<PropertyEntity> findById(Long id);
}
