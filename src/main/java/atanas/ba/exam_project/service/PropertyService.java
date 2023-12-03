package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.models.dto.PropertyDTO;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PropertyService {

    Page<PropertyDTO> findAllPropertiesForPropertiesPage(Pageable pageable);

    boolean addProperty(AddPropertyBindingModel addPropertyBindingModel);

    Optional<PropertyEntity> findById(Long id);

    PropertyEntity deleteProperty(Long id);
}
