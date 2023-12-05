package ro.sda.advanced_testing.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.repositories.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getByIdTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("mircea");
        user.setEmail("mircea@gmail.com");
        user.setPassword("1234");

        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));

       Optional<User> result = userService.findById(1);
       assertTrue(result.isPresent());
       assertEquals(result.get().getUsername(),"mircea");
    }

}
