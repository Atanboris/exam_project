package atanas.ba.exam_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {
    @GetMapping("/users/login")
    public ModelAndView login(){
    return new ModelAndView("login");
    }

    @PostMapping("users/login-error")
    public ModelAndView onFailure(@ModelAttribute("email") String email){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("email",email);
        modelAndView.addObject("bad_credentials", true);
        return modelAndView;
    }

}
