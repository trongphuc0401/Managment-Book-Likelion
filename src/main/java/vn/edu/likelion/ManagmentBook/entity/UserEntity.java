package vn.edu.likelion.ManagmentBook.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserEntity -
 *
 * @param
 * @return
 * @throws
 */

@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false , length = 100)
    private String password;
}
