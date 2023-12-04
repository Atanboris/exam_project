package atanas.ba.exam_project.repositories;

import atanas.ba.exam_project.models.entities.ViewingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ViewingRepository extends JpaRepository<ViewingEntity, Long> {

   Optional<ViewingEntity> findByViewingDateAndTime(String viewingDate, String time);
}
