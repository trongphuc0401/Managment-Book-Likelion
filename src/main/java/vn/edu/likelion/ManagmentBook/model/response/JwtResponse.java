package vn.edu.likelion.ManagmentBook.model.response;

import lombok.Data;

/**
 * JwtResponse -
 *
 * @param
 * @return
 * @throws
 */
@Data
public class JwtResponse {
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    
}
