package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.models.dto.PropertyDTO;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.repositories.PropertyRepository;
import atanas.ba.exam_project.service.PropertyService;
import atanas.ba.exam_project.service.ViewingService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private ViewingService viewingService;
    private ModelMapper modelMapper;

    public PropertyServiceImpl(PropertyRepository propertyRepository, ViewingService viewingService, ModelMapper modelMapper) {
        this.propertyRepository = propertyRepository;
        this.viewingService = viewingService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<PropertyDTO> findAllPropertiesForPropertiesPage(Pageable pageable) {
          return this.propertyRepository.findAll(pageable).map(r -> modelMapper.map(r,PropertyDTO.class));

    }


    @Override
    public boolean addProperty(AddPropertyBindingModel addPropertyBindingModel) {
        if(addPropertyBindingModel == null){
            return false;
        }
        if(addPropertyBindingModel.getPropertyAddress().isBlank()
        || addPropertyBindingModel.getPropertyImage().isBlank()
        || addPropertyBindingModel.getPropertyType() == null
        || addPropertyBindingModel.getAreaSize() <= 0
        || addPropertyBindingModel.getBedroomAmount() <= 0
        || addPropertyBindingModel.getBathroomAmount() <= 0
        || addPropertyBindingModel.getPrice() <= 0
        || addPropertyBindingModel.getParkingSpots() < 0){
            return false;
        }
       PropertyEntity property = modelMapper.map(addPropertyBindingModel,PropertyEntity.class);
        propertyRepository.save(property);
        return true;
    }

    @Override
    public Optional<PropertyEntity> findById(Long id) {

        return propertyRepository.findById(id);
    }

    @Override
    @Transactional
    public PropertyEntity deleteProperty(Long id) {
        Optional<PropertyEntity> property = propertyRepository.findById(id);
        if(property.isPresent()){
            viewingService.deleteAllByProperty(property.get());
            propertyRepository.delete(property.get());
            return property.get();
        }

        return null;
    }

}
