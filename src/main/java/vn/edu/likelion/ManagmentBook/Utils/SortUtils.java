package vn.edu.likelion.ManagmentBook.Utils;

import vn.edu.likelion.ManagmentBook.entity.BookEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortUtils -
 *
 * @param
 * @return
 * @throws
 */
public class SortUtils {

    public Iterable<BookEntity> sortPrice(Iterable<BookEntity> items) {
        List<BookEntity> bookList = new ArrayList<>();
        for(BookEntity book: items) {
            bookList.add(book);
        }
        bookList.sort((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
        return bookList;
    }
}
