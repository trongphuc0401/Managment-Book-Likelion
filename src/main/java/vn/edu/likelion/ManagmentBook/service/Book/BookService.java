package vn.edu.likelion.ManagmentBook.service.Book;

import vn.edu.likelion.ManagmentBook.entity.BookEntity;
import vn.edu.likelion.ManagmentBook.service.InterfaceBaseService;

/**
 * BookService -
 *
 * @param
 * @return
 * @throws
 */
public interface BookService extends InterfaceBaseService<BookEntity,Integer> {
    Iterable<BookEntity> getSortedBookByPrice();
}
