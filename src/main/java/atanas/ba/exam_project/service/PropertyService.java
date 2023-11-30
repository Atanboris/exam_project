package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.models.dto.PropertiesDTO;

public interface PropertyService {

    PropertiesDTO findAllPropertiesForPropertiesPage();

    boolean addProperty(AddPropertyBindingModel addPropertyBindingModel);
}
