package mhkif.yc.usersservice.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mhkif.yc.usersservice.dto.HttpResponse;
import mhkif.yc.usersservice.dto.requests.EmailPasswordReq;
import mhkif.yc.usersservice.dto.requests.UserReq;
import mhkif.yc.usersservice.dto.responses.UserRes;
import mhkif.yc.usersservice.entities.User;
import mhkif.yc.usersservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("tourism/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;
    private final ModelMapper mapper;

    @PostMapping("login")
    public ResponseEntity<HttpResponse> login(@RequestBody EmailPasswordReq request) {
        User user = service.auth(request.getEmail(), request.getPassword());
        return ResponseEntity.accepted().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .path("tourism/api/v1/auth")
                        .status(HttpStatus.ACCEPTED)
                        .message(user.getRole() + " has been authenticated")
                        .developerMessage(user.getRole() + " has been authenticated")
                        .data(Map.of(
                                "response", mapper.map(user, UserRes.class)
                                ))
                        .build()
        );
    }

    @PostMapping("register")
    public ResponseEntity<HttpResponse> register(@Valid @RequestBody UserReq request) {
        UserRes user = service.create(request);
        return ResponseEntity.accepted().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/register")
                        .status(HttpStatus.CREATED)
                        .message("User has been created successfully")
                        .developerMessage("User has been created successfully")
                        .data(Map.of("response", user))
                        .build()
        );
    }

}