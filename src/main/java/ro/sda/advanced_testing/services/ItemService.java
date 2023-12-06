package ro.sda.advanced_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.advanced_testing.entities.Item;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll(); // ne returneaza o lista cu toate registrarile din tabela user(echivalentul lui SELECT*FROM TBL_USERS).
    }
    public Optional<Item> findById(Integer id){
        return itemRepository.findById(id);
    }
    public Item createItem(Item item){
        return itemRepository.save(item); // metoda "save" ne adauga in baza de date un obiect de tipul user.
    }

    public Item updateItem(Item item){
        return itemRepository.save(item); // metoda "save" stie sa faca diferenta intre insert si update.
    }

    public void deleteItem(Item item){
        itemRepository.delete(item); // metoda delete ne ajuta sa stergem din baza de date un obiect de tipul user.
    }

    public void deleteById(Integer id){
        itemRepository.deleteById(id);
    }
}
