package vn.edu.likelion.ManagmentBook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book -
 *
 * @param
 * @return
 * @throws
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String name;

    private int stock;

    private double price;


}
