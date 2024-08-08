package vn.edu.likelion.ManagmentBook.service;

import java.util.Optional;

/**
 * InterfaceBaseService -
 *
 * @param
 * @return
 * @throws
 */
public interface InterfaceBaseService <T,ID>{
    T create(T t);
    T update(ID id,T t);
    void delete(T t);
    void deleteAll(Iterable<T> ts);
    Optional<T> getById(ID id);
    Iterable<T> getAll();
}
