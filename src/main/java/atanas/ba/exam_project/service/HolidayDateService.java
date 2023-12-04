package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.dto.HolidayDateDTO;
import atanas.ba.exam_project.models.entities.HolidayDateEntity;

import java.time.LocalDate;

public interface HolidayDateService {
    void refreshDates(HolidayDateDTO[] holidayDatesDTO);

    HolidayDateEntity findByDate(LocalDate viewingDate);
}
