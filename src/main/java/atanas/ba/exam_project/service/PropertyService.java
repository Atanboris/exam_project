package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.models.dto.PropertiesDTO;
import atanas.ba.exam_project.models.dto.PropertyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PropertyService {

    Page<PropertyDTO> findAllPropertiesForPropertiesPage(Pageable pageable);

    boolean addProperty(AddPropertyBindingModel addPropertyBindingModel);
}
