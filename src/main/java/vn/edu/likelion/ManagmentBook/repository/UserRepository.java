package vn.edu.likelion.ManagmentBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.ManagmentBook.entity.UserEntity;

import java.util.Optional;

/**
 * UserRepository -
 *
 * @param
 * @return
 * @throws
 */
@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
