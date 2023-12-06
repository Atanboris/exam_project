package atanas.ba.exam_project.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class UserRegisterControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegister() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("name", "Pesho Samaka")
                        .param("email", "Salut@abv.bg")
                        .param("password", "secret")
                        .param("confirmPassword", "secret")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/login"));
    }
    @Test
    void testRegisterWithFake() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("name", "Pesho Samaka")
                        .param("email", "Salut@abv.bg")
                        .param("password", "secr")
                        .param("confirmPassword", "secret")
                        .with(csrf())
        ).andExpect(status().is2xxSuccessful())
                .andExpect(view().name("register"));
    }
}