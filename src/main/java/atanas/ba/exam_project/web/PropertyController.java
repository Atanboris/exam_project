package atanas.ba.exam_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyController {
    @GetMapping("/property-details")
    public ModelAndView propertyDetails(){
        return new ModelAndView("property-details");
    }
}
