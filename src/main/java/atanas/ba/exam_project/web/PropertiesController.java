package atanas.ba.exam_project.web;

import atanas.ba.exam_project.service.PropertyService;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertiesController {
    private PropertyService propertyService;

    public PropertiesController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties/all")
    public ModelAndView properties(@PageableDefault(
            size = 4,
            sort = "id"
    )Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("properties");
        modelAndView.addObject("properties",this.propertyService.findAllPropertiesForPropertiesPage(pageable));
        return modelAndView;
    }
}
