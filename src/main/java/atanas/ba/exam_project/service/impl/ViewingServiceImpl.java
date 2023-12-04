package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.bindingModels.ViewingBindingModel;
import atanas.ba.exam_project.models.entities.HolidayDateEntity;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.models.entities.UserEntity;
import atanas.ba.exam_project.models.entities.ViewingEntity;
import atanas.ba.exam_project.repositories.HolidayDateRepository;
import atanas.ba.exam_project.repositories.PropertyRepository;
import atanas.ba.exam_project.repositories.UserRepository;
import atanas.ba.exam_project.repositories.ViewingRepository;
import atanas.ba.exam_project.service.HolidayDateService;
import atanas.ba.exam_project.service.ViewingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ViewingServiceImpl implements ViewingService {

    private final UserRepository userRepository;
    private final ViewingRepository viewingRepository;

    private final PropertyRepository propertyRepository;


    public ViewingServiceImpl(UserRepository userRepository, ViewingRepository viewingRepository,
                               PropertyRepository propertyRepository) {
        this.userRepository = userRepository;
        this.viewingRepository = viewingRepository;

        this.propertyRepository = propertyRepository;

    }

    @Override
    public boolean validSchedule(ViewingBindingModel viewingBindingModel) {
        if(viewingBindingModel.getViewingDate().isBlank()
        ||viewingBindingModel.getTime().isBlank()){
            return false;
        }

        LocalDate viewingDate = LocalDate.parse(viewingBindingModel.getViewingDate());
        if(viewingDate.isBefore(LocalDate.now())){
            return false;
        }


        return true;
    }


    @Override
    public boolean notInRepository(ViewingBindingModel viewingBindingModel, String currentUser, long id) {
        if(viewingRepository.findByViewingDateAndTime(viewingBindingModel.getViewingDate()
                ,viewingBindingModel.getTime()).isPresent()){
            return false;
        }

        UserEntity user = userRepository.findByEmail(currentUser).get();
        PropertyEntity property = propertyRepository.findById(id).get();

        //creates and saves non-existant viewingEntity
        ViewingEntity viewingEntity = new ViewingEntity();
        //TODO
        viewingEntity.setViewingDate(viewingBindingModel.getViewingDate());
        viewingEntity.setTime(viewingBindingModel.getTime());
        viewingEntity.setUser(user);
        viewingEntity.setProperty(property);

        viewingRepository.save(viewingEntity);
        return true;
    }
}
