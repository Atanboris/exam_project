package atanas.ba.exam_project.service.impl;

import atanas.ba.exam_project.models.bindingModels.RegisterUserBindingModel;
import atanas.ba.exam_project.models.entities.UserEntity;
import atanas.ba.exam_project.models.entities.UserRoleEntity;
import atanas.ba.exam_project.models.enums.UserRoleEnum;
import atanas.ba.exam_project.repositories.UserRepository;
import atanas.ba.exam_project.repositories.UserRoleRepository;
import atanas.ba.exam_project.service.UserRoleService;
import atanas.ba.exam_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final UserRoleService userRoleService;

    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(RegisterUserBindingModel registerUserBindingModel) {
        if(registerUserBindingModel.getEmail().isBlank()
        || userRepository.findByEmail(registerUserBindingModel.getEmail()).isPresent()
                || registerUserBindingModel.getPassword().isBlank()
        || !registerUserBindingModel.getPassword().equals(registerUserBindingModel.getConfirmPassword())){
            return false;
        }
        String newPassword = passwordEncoder.encode(registerUserBindingModel.getPassword());

        UserEntity registeredUser = modelMapper.map(registerUserBindingModel, UserEntity.class);

        registeredUser.setPassword(newPassword);

        List<UserRoleEntity> roleList = new ArrayList<>();
        roleList.add(userRoleService.findByRole(UserRoleEnum.USER));

        userRepository.save(registeredUser);

        return true;
    }
}
