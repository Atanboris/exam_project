package atanas.ba.exam_project.web;

import atanas.ba.exam_project.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertiesController {
    private PropertyService propertyService;

    public PropertiesController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties")
    public ModelAndView properties(){
        ModelAndView modelAndView = new ModelAndView("properties");
        modelAndView.addObject("propertiesDTO",this.propertyService.findAllPropertiesForPropertiesPage());
        return modelAndView;
    }
}
