package ro.sda.advanced_testing.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")// aceasta metoda se va apela cand vom avea un request de tipul Get.
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.findAll();

        return ResponseEntity.ok(userList);

    }
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        // apelam metoda createUser din service pentru a salva userul in baza de date.
         User savedUser =  userService.createUser(user);
         return ResponseEntity.ok(savedUser);

    }
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable ("id")Integer id){
        System.out.println("Userul cu id-ul " + id + " va fii sters!!!" );
        userService.deleteById(id);
        return ResponseEntity.ok("user sters"); // mesajul pe care il vom primi pe postman.
    }
}
