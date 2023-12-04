package ro.sda.advanced_testing.services;

import org.springframework.stereotype.Service;
import ro.sda.advanced_testing.entities.User;
import ro.sda.advanced_testing.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll(); // ne returneaza o lista cu toate registrarile din tabela user(echivalentul lui SELECT*FROM TBL_USERS).
    }
    public User createUser(User user){
        return userRepository.save(user); // metoda "save" ne adauga in baza de date un obiect de tipul user.
    }

    public User updateUser(User user){
        return userRepository.save(user); // metoda "save" stie sa faca diferenta intre insert si update.
    }

    public void deleteUser(User user){
        userRepository.delete(user); // metoda delete ne ajuta sa stergem din baza de date un obiect de tipul user.
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

}
