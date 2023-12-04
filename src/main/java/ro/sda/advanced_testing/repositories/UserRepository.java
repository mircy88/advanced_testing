package ro.sda.advanced_testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.advanced_testing.entities.User;

@Repository //ii spune Springului ca aceasta interfata ne va ajuta sa gestionam BD.
public interface UserRepository extends JpaRepository<User,Integer> {


}
