package atanas.ba.exam_project.web;

import atanas.ba.exam_project.models.entities.HolidayDateEntity;
import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.models.entities.UserEntity;
import atanas.ba.exam_project.models.entities.UserRoleEntity;
import atanas.ba.exam_project.models.enums.PropertyType;
import atanas.ba.exam_project.models.enums.UserRoleEnum;
import atanas.ba.exam_project.repositories.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class ViewingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HolidayDateRepository holidayDateRepositoryTest;

    @Autowired
    private UserRepository userRepositoryTest;

    @Autowired
    private PropertyRepository propertyRepositoryTest;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private ViewingRepository viewingRepositoryTest;

    @BeforeEach
    void setUp(){
        //Set Holiday
        HolidayDateEntity holidayDate = new HolidayDateEntity();
        holidayDate.setDate(LocalDate.parse("2023-11-01"));
        holidayDate.setName("All Saints' Day");
        holidayDate.setLocalName("Allerheiligen");
        holidayDate.setCountryCode("AT");

        holidayDateRepositoryTest.save(holidayDate);
        //Set Holiday

        //Set User
        UserEntity user = new UserEntity();
        user.setName("Flashie goal");
        user.setEmail("user@gmail.com");
        user.setPassword("12345");
        List<UserRoleEntity> roles = List.of(
                userRoleRepository.findByRole(UserRoleEnum.USER)
        );
        user.setRoles(roles);
        userRepositoryTest.save(user);
        //Set User

        //Set Property
        PropertyEntity property = new PropertyEntity(BigDecimal.valueOf(123000), "Leben 72", PropertyType.VILLA,
                7, 2, 72, 1,
                "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmlsbGF8ZW58MHx8MHx8fDA%3D");
        propertyRepositoryTest.save(property);
        //Set Property
    }
    @AfterEach
    void tearUp(){
        viewingRepositoryTest.deleteAll();
        holidayDateRepositoryTest.deleteAll();
        userRepositoryTest.deleteAll();
        propertyRepositoryTest.deleteAll();
    }
    @Test
    @WithMockUser(username = "user@gmail.com")
    void testAddViewing() throws Exception {
      Long propertyId = propertyRepositoryTest.findByPropertyAddress("Leben 72").get().getId();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/viewing/schedule/{id}", propertyId)
                        .param("viewingDate", "2023-12-21")
                        .param("time", "11:00:00")
                        .with(csrf())
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/properties/all"));
    }

}