package mhkif.yc.usersservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponse {
    private String timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String message;
    private String developerMessage;
    private String path;
    private String requestMethod;
}
