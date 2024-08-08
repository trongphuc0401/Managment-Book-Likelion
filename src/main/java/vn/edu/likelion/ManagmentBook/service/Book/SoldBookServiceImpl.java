package vn.edu.likelion.ManagmentBook.service.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import vn.edu.likelion.ManagmentBook.entity.SolvedBookEntity;

import java.util.Optional;

/**
 * SolvedBookServiceImpl -
 *
 * @param
 * @return
 * @throws
 */
@Service
public class SoldBookServiceImpl implements SoldBookService {

    @Autowired
    @Lazy
    private SoldBookService soldBookService;

    @Override
    public SolvedBookEntity create(SolvedBookEntity soldBookEntity) {
        return soldBookService.create(soldBookEntity);
    }

    @Override
    public SolvedBookEntity update(Integer integer, SolvedBookEntity solvedBookEntity) {
        return null;
    }

    @Override
    public void delete(SolvedBookEntity solvedBookEntity) {

    }

    @Override
    public void deleteAll(Iterable<SolvedBookEntity> solvedBookEntities) {

    }

    @Override
    public Optional<SolvedBookEntity> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<SolvedBookEntity> getAll() {
        return null;
    }
}
