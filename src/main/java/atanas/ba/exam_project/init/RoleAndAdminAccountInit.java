package atanas.ba.exam_project.init;

import atanas.ba.exam_project.models.entities.UserEntity;
import atanas.ba.exam_project.models.entities.UserRoleEntity;
import atanas.ba.exam_project.models.enums.UserRoleEnum;
import atanas.ba.exam_project.repositories.UserRepository;
import atanas.ba.exam_project.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RoleAndAdminAccountInit implements CommandLineRunner {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public RoleAndAdminAccountInit(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean hasRoles = userRoleRepository.count() > 0;
        if(!hasRoles){
                userRoleRepository.saveAll(getAllRoles());
        }
        if(userRepository.findByEmail("admin@admin.com").isEmpty()){
            UserEntity adminUser = new UserEntity(gettingRolesForAdmin(userRoleRepository), "Admin", "admin@admin.com", "$2a$10$S73sc..tFXm1mrrgVK2wVeiQmJiCyxxUA5a6hhr7I/UGKOuNP.Ita");
            userRepository.save(adminUser);
        }
    }

    private static List<UserRoleEntity> getAllRoles(){
        List<UserRoleEntity> roles = new ArrayList<>();
        Arrays.stream(UserRoleEnum.values())
                .forEach(role ->{
                    UserRoleEntity currentRole = new UserRoleEntity();
                    currentRole.setRole(role);
                    roles.add(currentRole);
                });
        return roles;
    }
    private static List<UserRoleEntity> gettingRolesForAdmin(UserRoleRepository userRoleRepository){
        return userRoleRepository.findAll();
    }

}
