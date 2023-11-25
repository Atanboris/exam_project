package atanas.ba.exam_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @GetMapping("/contact")
    public ModelAndView contact(){
        return new ModelAndView("contact");
    }

}
