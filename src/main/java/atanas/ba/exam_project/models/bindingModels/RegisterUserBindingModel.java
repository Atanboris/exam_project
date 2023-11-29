package atanas.ba.exam_project.models.bindingModels;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserBindingModel {
    @Size(min = 3, max = 40,message = "Name length must be between 3 and 40 characters!")
    private String name;
    @Email
    @NotBlank(message = "Email cannot be empty!")
    private String email;
    @Size(min = 3, max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
