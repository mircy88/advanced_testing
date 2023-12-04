package ro.sda.advanced_testing.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// ne ajuta sa avem un id unic, se va incrementa
    private Integer id;
    private String username;
    private String email;
    private String password;


}
