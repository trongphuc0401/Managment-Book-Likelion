package vn.edu.likelion.ManagmentBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.ManagmentBook.Utils.JwtUtil;
import vn.edu.likelion.ManagmentBook.Utils.StringUtils;
import vn.edu.likelion.ManagmentBook.entity.BookEntity;
import vn.edu.likelion.ManagmentBook.entity.SolvedBookEntity;
import vn.edu.likelion.ManagmentBook.entity.UserEntity;
import vn.edu.likelion.ManagmentBook.model.BookDTO;
import vn.edu.likelion.ManagmentBook.model.response.ResponseModel;
import vn.edu.likelion.ManagmentBook.service.Book.BookService;
import vn.edu.likelion.ManagmentBook.service.Book.SoldBookService;
import vn.edu.likelion.ManagmentBook.service.User.UserService;

import java.time.LocalDateTime;

import java.util.Iterator;
import java.util.Optional;

/**
 * BookController -
 *
 * @param
 * @return
 * @throws
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    private final UserService userService;

    private final SoldBookService soldBookService;


    public BookController(BookService bookService, UserService userService, SoldBookService soldBookService) {
        this.bookService = bookService;
        this.userService = userService;
        this.soldBookService = soldBookService;
    };

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookDTO bookDTO) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookDTO.getName());
        bookEntity.setStock(bookDTO.getStock());
        bookEntity.setPrice(bookDTO.getPrice());
        bookService.create(bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookEntity);
    }

    @GetMapping
    public Iterator<BookEntity> getAllBook() {
        return bookService.getAll().iterator();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> findBookById(@PathVariable("bookId") Integer bookId) {
        Optional<BookEntity> bookEntity = bookService.getById(bookId);
        return bookEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/sort/price")
    public Iterator<BookEntity> getSortedBookByPrice() {
        return bookService.getSortedBookByPrice().iterator();
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable("bookId") Integer bookId ,@RequestBody BookDTO bookDTO) {
        Optional<BookEntity> bookEntity = bookService.getById(bookId);
        if (bookEntity.isPresent()) {
            BookEntity book = bookEntity.get();
            book.setName(bookDTO.getName());
            book.setStock(bookDTO.getStock());
            book.setPrice(bookDTO.getPrice());
            bookService.update(bookId,book);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId) {
        Optional<BookEntity> bookEntity = bookService.getById(bookId);
        if (bookEntity.isPresent()) {
            bookService.delete(bookEntity.orElseGet(bookEntity::get));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/purchase/{bookId}")
    public ResponseEntity<SolvedBookEntity> purchaseSoldBook(@PathVariable("bookId") Integer bookId , @RequestParam("userId")  Integer userId) {
        Optional<BookEntity> bookEntity = bookService.getById(bookId);
        Optional<UserEntity> userEntity = userService.getById(userId);
        LocalDateTime now = LocalDateTime.now();
        if (bookEntity.isPresent() && userEntity.isPresent()) {

            SolvedBookEntity solvedBookEntity = SolvedBookEntity.builder()
                    .name(bookEntity.get().getName())
                    .price(bookEntity.get().getPrice())
                    .purchaseDate(now)
                    .userId(userEntity.get()).build();
            soldBookService.create(solvedBookEntity);
            return new ResponseEntity<>(solvedBookEntity, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
