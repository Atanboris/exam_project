package atanas.ba.exam_project.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "viewings")
public class ViewingEntity extends BaseEntity {
    @Column(name = "viewing_date",nullable = false)
    @Size(max = 10)
    private String viewingDate;
    @Column(nullable = false)
    @Size(max = 10)
    private String time;
    @NotNull
    @ManyToOne
    private PropertyEntity property;
    @NotNull
    @ManyToOne
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }
}
