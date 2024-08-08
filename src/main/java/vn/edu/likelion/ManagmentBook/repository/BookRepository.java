package vn.edu.likelion.ManagmentBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.ManagmentBook.entity.BookEntity;

import java.util.Optional;

/**
 * ProductRepository -
 *
 * @param
 * @return
 * @throws
 */

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {


    Optional<BookEntity> findById(Integer id);




}
