package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.dto.HolidayDateDTO;
import atanas.ba.exam_project.models.entities.HolidayDateEntity;
import atanas.ba.exam_project.repositories.HolidayDateRepository;
import atanas.ba.exam_project.service.HolidayDateService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class HolidayDateServiceImpl implements HolidayDateService {
    private final HolidayDateRepository holidayDateRepository;
    private ModelMapper modelMapper;

    public HolidayDateServiceImpl(HolidayDateRepository holidayDateRepository, ModelMapper modelMapper) {
        this.holidayDateRepository = holidayDateRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void refreshDates(HolidayDateDTO[] holidayDatesDTO) {
        if(holidayDateRepository.count() > 0){
            holidayDateRepository.deleteAll();
        }
        HashSet<HolidayDateEntity> holidayDates = new HashSet<>();
        for (HolidayDateDTO holiday: holidayDatesDTO) {
          holidayDates.add(modelMapper.map(holiday, HolidayDateEntity.class));
        }
        holidayDateRepository.saveAll(holidayDates);
    }
}
