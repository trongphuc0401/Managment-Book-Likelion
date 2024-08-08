package vn.edu.likelion.ManagmentBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.likelion.ManagmentBook.Utils.JwtUtil;
import vn.edu.likelion.ManagmentBook.entity.UserEntity;
import vn.edu.likelion.ManagmentBook.model.UserDTO;
import vn.edu.likelion.ManagmentBook.model.response.JwtResponse;
import vn.edu.likelion.ManagmentBook.service.User.UserService;

import java.util.Optional;

/**
 * UserController -
 *
 * @param
 * @return
 * @throws
 */
@RequestMapping("/api/auth")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userService.registerUser(userDTO.getUsername(), userDTO.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(userEntity);
    }

    @PostMapping("/login")
    public  ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        Optional<UserEntity> userEntity = userService.authenticateUser(userDTO.getUsername(), userDTO.getPassword());
        if(userEntity.isPresent()) {
            String token = jwtUtil.generateToken(userEntity.get().getUsername());
            return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
