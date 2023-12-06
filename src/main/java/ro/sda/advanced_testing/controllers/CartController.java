package ro.sda.advanced_testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.advanced_testing.dto.CartDto;
import ro.sda.advanced_testing.entities.Cart;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.services.CartService;
import ro.sda.advanced_testing.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Cart>> getAllCarts() {

        List<Cart> cartList = cartService.findAll();
        return ResponseEntity.ok(cartList);

    }

    @PostMapping("/")
    public ResponseEntity<Cart> createCart(@RequestBody CartDto cartBody) {
        Optional<User> userOptional = userService.findById(cartBody.getUserId());

        Cart savedCart = new Cart();
        savedCart.setUser(userOptional.get());
        savedCart.setItems(cartBody.getItems());

        Cart cart = cartService.createCart(savedCart);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/")
    public ResponseEntity<Cart> updateCart(@RequestBody CartDto cartBody) {
        Optional<User> userOptional = userService.findById(cartBody.getUserId());

        Cart savedCart = new Cart();
        savedCart.setId(cartBody.getId());
        savedCart.setUser(userOptional.get());
        savedCart.setItems(cartBody.getItems());

        Cart cart = cartService.updateCart(savedCart);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Integer id) {
        cartService.deleteCartById(id);
        return ResponseEntity.ok("Cart sters cu success!");
    }


}
