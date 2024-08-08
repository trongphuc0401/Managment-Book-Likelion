package vn.edu.likelion.ManagmentBook.service.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.ManagmentBook.Utils.SortUtils;
import vn.edu.likelion.ManagmentBook.Utils.StringUtils;
import vn.edu.likelion.ManagmentBook.entity.BookEntity;
import vn.edu.likelion.ManagmentBook.repository.BookRepository;

import java.util.Optional;

/**
 * BookServiceImpl -
 *
 * @param
 * @return
 * @throws
 */

@Service
public class BookServiceImpl implements BookService  {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity update(Integer id, BookEntity bookEntity) {
        bookEntity.setId(id);
        return bookRepository.save(bookEntity);

    }

    @Override
    public void delete(BookEntity bookEntity) {
        bookRepository.delete(bookEntity);
    }

    @Override
    public void deleteAll(Iterable<BookEntity> bookEntities) {

    }

    @Override
    public Optional<BookEntity> getById(Integer integer) {
        return bookRepository.findById(integer);
    }

    @Override
    public Iterable<BookEntity> getAll() {
        return bookRepository.findAll();
    }


    @Override
    public Iterable<BookEntity> getSortedBookByPrice() {
        SortUtils sortUtils = new SortUtils();
        Iterable<BookEntity> items = bookRepository.findAll();
        items = sortUtils.sortPrice(items);
        return items;
    }
}
