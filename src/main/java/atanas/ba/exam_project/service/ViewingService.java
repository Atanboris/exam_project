package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.bindingModels.ViewingBindingModel;

public interface ViewingService {

    boolean validSchedule(ViewingBindingModel viewingBindingModel);

    boolean notInRepository(ViewingBindingModel viewingBindingModel, String currentUser, long id);

    void cleanUpMeetings();
}
