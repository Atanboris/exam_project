package atanas.ba.exam_project.models.entities;

import atanas.ba.exam_project.models.enums.UserRoleEnum;
import jakarta.persistence.*;

@Table(name = "roles")
@Entity
public class UserRoleEntity extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;


    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
