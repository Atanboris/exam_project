package atanas.ba.exam_project.config.init;

import atanas.ba.exam_project.models.entities.UserRoleEntity;
import atanas.ba.exam_project.models.enums.UserRoleEnum;
import atanas.ba.exam_project.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RoleInit implements CommandLineRunner {
    private final UserRoleRepository userRoleRepository;

    public RoleInit(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean hasRoles = userRoleRepository.count() > 0;
        if(!hasRoles){
            List<UserRoleEntity> roles = new ArrayList<>();
            Arrays.stream(UserRoleEnum.values())
                    .forEach(role -> {
                        UserRoleEntity userRole = new UserRoleEntity();
                        userRole.setRole(role);
                        roles.add(userRole);
                    });
                userRoleRepository.saveAll(roles);
        }
    }
}
