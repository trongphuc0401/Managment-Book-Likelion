package vn.edu.likelion.ManagmentBook.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.likelion.ManagmentBook.entity.UserEntity;
import vn.edu.likelion.ManagmentBook.model.UserDTO;
import vn.edu.likelion.ManagmentBook.repository.UserRepository;

import java.util.Optional;

/**
 * UserServiceImpl -
 *
 * @param
 * @return
 * @throws
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
    }

    public Optional<UserEntity> authenticateUser(String username, String password) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return null;
    }






    @Override
    public UserEntity create(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity update(Integer integer, UserEntity userEntity) {
        return null;
    }

    @Override
    public void delete(UserEntity userEntity) {

    }

    @Override
    public void deleteAll(Iterable<UserEntity> userEntities) {

    }

    @Override
    public Optional<UserEntity> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<UserEntity> getAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userDetail = userRepository.findByUsername(username);

        System.err.println(userDetail.get().getUsername());
        // Converting userDetail to UserDetails
        return userDetail.map(UserDTO::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "));
    }
}
