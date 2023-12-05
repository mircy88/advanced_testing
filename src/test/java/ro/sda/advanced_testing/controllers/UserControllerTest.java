package ro.sda.advanced_testing.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("mircea");
        user.setEmail("mircea@gmail.com");
        user.setPassword("1234");

        Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users/").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("mircea@gmail.com"))
                .andExpect(jsonPath("$.username").value("mircea"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.password").value("1234"));
    }
    @Test
    public void getAllUsersTest()throws Exception{
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user1");
        user1.setEmail("user1@gmail.com");
        user1.setPassword("1234");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");
        user2.setEmail("user2@gmail.com");
        user2.setPassword("1234");

        List<User>userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Mockito.when(userService.findAll()).thenReturn(userList);
        mockMvc.perform(get("/users/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andExpect(jsonPath("$[0].username").value("user1"))
                .andExpect(jsonPath("$[0].email").value("user1@gmail.com"))
                .andExpect(jsonPath("$[0].password").value("1234"))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[1].username").value("user2"))
                .andExpect(jsonPath("$[1].email").value("user2@gmail.com"))
                .andExpect(jsonPath("$[1].password").value("1234"))
                .andExpect(jsonPath("$[1].id").value("2"));
    }
}
