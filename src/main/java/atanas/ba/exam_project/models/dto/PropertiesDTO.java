package atanas.ba.exam_project.models.dto;

import java.util.List;

public class PropertiesDTO {

    private List<PropertyDTO> properties;

    public PropertiesDTO(List<PropertyDTO> properties) {
        this.properties = properties;
    }

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }
}
