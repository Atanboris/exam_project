package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.dto.HolidayDateDTO;

public interface HolidayDateService {
    void refreshDates(HolidayDateDTO[] holidayDatesDTO);
}
