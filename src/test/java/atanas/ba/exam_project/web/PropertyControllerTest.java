package atanas.ba.exam_project.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class PropertyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser(username = "admin", roles = {"USER","ADMIN"})
    void addProperty() throws Exception {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/property/add")
                            .param("propertyAddress", "Selben 72")
                            .param("propertyImage", "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmlsbGF8ZW58MHx8MHx8fDA%3D")
                            .param("bedroomAmount", "2")
                            .param("bathroomAmount", "30")
                            .param("areaSize", "72")
                            .param("parkingSpots", "2")
                            .param("propertyType", "VILLA")
                            .param("price", "123000")
                            .with(csrf())
            ).andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/home"));
    }
}