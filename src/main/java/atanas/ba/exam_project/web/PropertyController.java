package atanas.ba.exam_project.web;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/property-details")
    public ModelAndView propertyDetails(){
        return new ModelAndView("property-details");
    }
    @GetMapping("/property/add")
    public ModelAndView addProperty(@ModelAttribute("addPropertyBindingModel")
                                        AddPropertyBindingModel addPropertyBindingModel){
        return new ModelAndView("add-property");
    }
    @PostMapping("/property/add")
    public ModelAndView addProperty(@ModelAttribute("addPropertyBindingModel") @Valid
                                    AddPropertyBindingModel addPropertyBindingModel,
                                    BindingResult bindingResult){
        boolean hasPropertyBeenAdded = this.propertyService.addProperty(addPropertyBindingModel);
        if(hasPropertyBeenAdded){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("add-property");
    }
}

