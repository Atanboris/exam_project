package atanas.ba.exam_project.web;

import atanas.ba.exam_project.models.bindingModels.ViewingBindingModel;
import atanas.ba.exam_project.models.entities.HolidayDateEntity;
import atanas.ba.exam_project.service.HolidayDateService;
import atanas.ba.exam_project.service.ViewingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequestMapping("/viewing/schedule")
public class ViewingController {
    private final ViewingService viewingService;
    private final HolidayDateService holidayDateService;

    public ViewingController(ViewingService viewingService, HolidayDateService holidayDateService) {
        this.viewingService = viewingService;
        this.holidayDateService = holidayDateService;
    }

    @GetMapping("/{id}")
    public ModelAndView scheduleMeeting(@PathVariable("id") long id,
                                        @ModelAttribute("viewingBindingModel")
                                            ViewingBindingModel viewingBindingModel,
                                            Principal principal
                                            ){
        ModelAndView modelAndView = new ModelAndView("property-schedule-viewing");
        modelAndView.addObject(viewingBindingModel);
        return modelAndView;
    }
    @PostMapping("/{id}")
    public ModelAndView scheduleMeeting(@PathVariable("id") long id,
                                            @ModelAttribute("viewingBindingModel")
                                            @Valid
                                            ViewingBindingModel viewingBindingModel,
                                        BindingResult bindingResult,
                                        Principal principal){
        ModelAndView modelAndView = new ModelAndView("property-schedule-viewing");
        String currentUser = principal.getName();

        boolean validSchedule = this.viewingService.validSchedule(viewingBindingModel);
        if(validSchedule){
            HolidayDateEntity holidayOnDate = this.holidayDateService
                    .findByDate(LocalDate.parse(viewingBindingModel.getViewingDate()));
            if(holidayOnDate == null){
                boolean notInRepository = this.viewingService
                        .notInRepository(viewingBindingModel,currentUser,id);
                if(notInRepository){
                    return new ModelAndView("redirect:/properties/all");
                }else {
                    modelAndView.addObject("isInRepository", false);
                }
            }else {
                modelAndView.addObject("isOnHoliday", true);
                modelAndView.addObject(holidayOnDate);
            }
        }
        return modelAndView;
    }



}
