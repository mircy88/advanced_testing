package ro.sda.advanced_testing.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    private Category category;

}
