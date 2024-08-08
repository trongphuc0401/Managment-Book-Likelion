package vn.edu.likelion.ManagmentBook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * Book -
 *
 * @param
 * @return
 * @throws
 */
@Table(name = "tbl_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column (nullable = false)
    private String name;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false,updatable = false)
    private LocalDateTime dateAdded;

    @Column(updatable = false)
    private LocalDateTime dateSolve;

    @PrePersist
    protected void onCreate() {
        dateAdded = LocalDateTime.now();
    }
}
