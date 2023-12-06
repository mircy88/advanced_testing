package ro.sda.advanced_testing.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.services.UserService;
import ro.sda.advanced_testing.utils.ApiResponse;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/")// aceasta metoda se va apela cand vom avea un request de tipul Get.
    public ResponseEntity<ApiResponse> getAllUsers(){
        List<User> userList = userService.findAll();
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("Lista utilizatori")
                .data(userList)
                .build();

        return ResponseEntity.ok(response);

    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user){
        // apelam metoda createUser din service pentru a salva userul in baza de date.
         User savedUser =  userService.createUser(user);
         ApiResponse response = new ApiResponse.Builder()
                 .status(200)
                 .message("User adaugat cu success!")
                 .data(savedUser)
                 .build();
         return ResponseEntity.ok(response);

    }
    @PutMapping("/")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("User modificat cu success!")
                .data(updatedUser)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser (@PathVariable ("id")Integer id){
        System.out.println("Userul cu id-ul " + id + " va fii sters!!!" );
        userService.deleteById(id);
        ApiResponse response = new ApiResponse.Builder()
                .status(200)
                .message("User sters cu success!")
                .data(null)
                .build();
        return ResponseEntity.ok(response);
    }
}
