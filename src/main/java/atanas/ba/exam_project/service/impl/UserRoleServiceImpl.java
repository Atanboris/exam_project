package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.entities.UserRoleEntity;
import atanas.ba.exam_project.models.enums.UserRoleEnum;
import atanas.ba.exam_project.repositories.UserRoleRepository;
import atanas.ba.exam_project.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleEntity findByRole(UserRoleEnum userRoleEnum) {
        return userRoleRepository.findByRole(userRoleEnum);

    }
}
