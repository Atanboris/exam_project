package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.bindingModels.RegisterUserBindingModel;

public interface UserService {
    boolean register(RegisterUserBindingModel registerUserBindingModel);
}
