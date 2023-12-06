package ro.sda.advanced_testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.advanced_testing.entities.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
