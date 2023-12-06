package atanas.ba.exam_project.web;

import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.models.enums.PropertyType;
import atanas.ba.exam_project.repositories.PropertyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PropertiesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PropertyRepository propertyRepository;

    @BeforeEach
    void setUp(){
        List<PropertyEntity> properties = List.of(
                new PropertyEntity(BigDecimal.valueOf(123000), "Leben 72", PropertyType.VILLA,
                        7, 2, 72, 1,
                        "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmlsbGF8ZW58MHx8MHx8fDA%3D"),
                new PropertyEntity(BigDecimal.valueOf(123000), "Leben 72", PropertyType.VILLA,
                        7, 2, 72, 1,
                        "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmlsbGF8ZW58MHx8MHx8fDA%3D"),
                new PropertyEntity(BigDecimal.valueOf(123000), "Leben 72", PropertyType.VILLA,
                        7, 2, 72, 1,
                        "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmlsbGF8ZW58MHx8MHx8fDA%3D")
        );
        propertyRepository.saveAll(properties);
    }
    @AfterEach
    void tearDown(){
        propertyRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "Gabriel@gmail.com")
    void propertiesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/properties/all"
        ).with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }
}