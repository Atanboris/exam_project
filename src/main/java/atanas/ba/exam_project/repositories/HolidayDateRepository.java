package atanas.ba.exam_project.repositories;

import atanas.ba.exam_project.models.entities.HolidayDateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HolidayDateRepository extends JpaRepository<HolidayDateEntity, String> {
    Optional<HolidayDateEntity> findByDate(LocalDate date);
}
