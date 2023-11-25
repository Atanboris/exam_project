package atanas.ba.exam_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegisterController {
    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

}
