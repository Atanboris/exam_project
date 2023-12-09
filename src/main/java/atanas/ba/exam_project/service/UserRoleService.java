package atanas.ba.exam_project.service;

import atanas.ba.exam_project.models.entities.UserRoleEntity;
import atanas.ba.exam_project.models.enums.UserRoleEnum;

public interface UserRoleService {
    UserRoleEntity findByRole(UserRoleEnum userRoleEnum);
}
