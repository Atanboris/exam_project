package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.models.dto.PropertiesDTO;
import atanas.ba.exam_project.models.dto.PropertyDTO;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.repositories.PropertyRepository;
import atanas.ba.exam_project.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private ModelMapper modelMapper;

    public PropertyServiceImpl(PropertyRepository propertyRepository, ModelMapper modelMapper) {
        this.propertyRepository = propertyRepository;
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
        || addPropertyBindingModel.getAreaSize() > 0
        || addPropertyBindingModel.getBedroomAmount() > 0
        || addPropertyBindingModel.getBathroomAmount() > 0
        || addPropertyBindingModel.getPrice() > 0
        ||addPropertyBindingModel.getParkingSpots() > 0){
            return false;
        }
       PropertyEntity property = modelMapper.map(addPropertyBindingModel,PropertyEntity.class);
        propertyRepository.save(property);
        return true;
    }

}
