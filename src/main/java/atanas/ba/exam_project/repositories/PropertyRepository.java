package atanas.ba.exam_project.repositories;

import atanas.ba.exam_project.models.entities.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    List<PropertyEntity> findAll();

    PropertyEntity getById(Long id);
}
