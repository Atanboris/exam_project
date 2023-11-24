package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.dto.PropertiesDTO;
import atanas.ba.exam_project.models.dto.PropertyDTO;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.repositories.PropertyRepository;
import atanas.ba.exam_project.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertiesDTO findAllPropertiesForPropertiesPage() {
        List<PropertyEntity> propertiesList = this.propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();

        for (PropertyEntity property:propertiesList) {
            PropertyDTO propertyDTO = new PropertyDTO(property);
            propertyDTOList.add(propertyDTO);
        }
        return new PropertiesDTO(propertyDTOList);
    }
}
