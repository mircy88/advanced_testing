package ro.sda.advanced_testing.dto;

import lombok.Data;
import ro.sda.advanced_testing.entities.Item;

import java.util.List;

@Data
public class CartDto {
    private Integer id;
    private Integer userId;
    private List<Item> items;
}
