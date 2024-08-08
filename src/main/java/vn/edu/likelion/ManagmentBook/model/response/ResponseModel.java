package vn.edu.likelion.ManagmentBook.model.response;

import java.time.LocalDate;

/**
 * ResponeModel -
 *
 * @param
 * @return
 * @throws
 */
public class ResponseModel {
    private final boolean status = true;
    private String timestamp;
    private Object data;

    public ResponseModel(Object data) {
        this.timestamp = LocalDate.now().toString();
        this.data = data;
    }
}
