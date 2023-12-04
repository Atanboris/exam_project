package atanas.ba.exam_project.models.bindingModels;

import atanas.ba.exam_project.validation.StringDateIsInPresentOrFuture;
import jakarta.validation.constraints.NotNull;


public class ViewingBindingModel {
    @StringDateIsInPresentOrFuture(message = "Date cannot be in the past")
    private String viewingDate;
    @NotNull(message = "Please select a time")
    private String time;


    public ViewingBindingModel() {
    }


    public String getViewingDate() {
        return viewingDate;
    }

    public void setViewingDate(String viewingDate) {
        this.viewingDate = viewingDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
