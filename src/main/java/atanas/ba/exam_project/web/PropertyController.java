package atanas.ba.exam_project.web;

import atanas.ba.exam_project.models.bindingModels.AddPropertyBindingModel;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/property/{id}")
    public ModelAndView propertyDetails(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("property-details");
        PropertyEntity property = propertyService.findById(id).get();
         modelAndView.addObject(property);
        return modelAndView;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/property/{id}")
    public ModelAndView deleteProperty(@PathVariable("id") Long id){
        propertyService.deleteProperty(id);
        return new ModelAndView("redirect:/properties/all");
    }
    @GetMapping("/property/add")
    public ModelAndView addProperty(@ModelAttribute("addPropertyBindingModel")
                                        AddPropertyBindingModel addPropertyBindingModel){
        return new ModelAndView("add-property");
    }
    @PreAuthorize("hasAuthority('ADMIN')")
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

