package vn.edu.likelion.ManagmentBook.service.User;

import vn.edu.likelion.ManagmentBook.entity.UserEntity;
import vn.edu.likelion.ManagmentBook.service.InterfaceBaseService;

import java.util.Optional;

/**
 * UserService -
 *
 * @param
 * @return
 * @throws
 */
public interface UserService extends InterfaceBaseService<UserEntity,Integer> {
     UserEntity registerUser(String username, String password);
     Optional<UserEntity> authenticateUser(String username, String password);

}
