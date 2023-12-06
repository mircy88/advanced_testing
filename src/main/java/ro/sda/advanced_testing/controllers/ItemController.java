package ro.sda.advanced_testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.advanced_testing.entities.Item;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.services.ItemService;
import ro.sda.advanced_testing.services.UserService;

import java.util.List;
@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;


    @GetMapping("/")// aceasta metoda se va apela cand vom avea un request de tipul Get.
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.findAll();

        return ResponseEntity.ok(itemList);

    }
    @PostMapping("/")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        // apelam metoda createUser din service pentru a salva userul in baza de date.
        Item savedItem =  itemService.createItem(item);
        return ResponseEntity.ok(savedItem);

    }
    @PutMapping("/")
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        Item updatedItem = itemService.updateItem(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem (@PathVariable ("id")Integer id){
        System.out.println("Itemul cu id-ul " + id + " va fii sters!!!" );
        itemService.deleteById(id);
        return ResponseEntity.ok("item sters"); // mesajul pe care il vom primi pe postman.
    }
}
