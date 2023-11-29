package atanas.ba.exam_project.web;

import atanas.ba.exam_project.models.bindingModels.RegisterUserBindingModel;
import atanas.ba.exam_project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegisterController {
    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public ModelAndView register(@ModelAttribute("registerUserBindingModel")
                                     RegisterUserBindingModel registerUserBindingModel){
        return new ModelAndView("register");
    }
    @PostMapping("users/register")
    public ModelAndView register (@ModelAttribute("registerUserBindingModel") @Valid
                                     RegisterUserBindingModel registerUserBindingModel,
                                  BindingResult bindingResult){
        boolean hasRegistered = userService.register(registerUserBindingModel);
        if(hasRegistered){
            return new ModelAndView("redirect:/");
        }
     return new ModelAndView("register");
    }

}
