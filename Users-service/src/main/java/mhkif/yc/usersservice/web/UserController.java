package mhkif.yc.usersservice.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mhkif.yc.usersservice.dto.HttpResponse;
import mhkif.yc.usersservice.dto.requests.UserReq;
import mhkif.yc.usersservice.dto.responses.UserRes;
import mhkif.yc.usersservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("tourism/api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService service;
    private final ModelMapper mapper;


    @PostMapping("")
    public ResponseEntity<HttpResponse> save(@Valid @RequestBody UserReq request){
        UserRes user = service.create(request);
        return ResponseEntity.accepted().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.CREATED)
                        .message("User has been created successfully")
                        .developerMessage("User has been created successfully")
                        .data(Map.of("response", user))
                        .build()
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpResponse> update(@RequestBody UserRes user, @PathVariable UUID id) {

        return ResponseEntity.accepted().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.ACCEPTED)
                        .message("User has been updated successfully")
                        .developerMessage("User has been updated successfully")
                        .data(Map.of("response", user))
                        .build()
        );
    }
    @GetMapping("/pages")
    public ResponseEntity<HttpResponse> getPagination(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false,defaultValue = "5") int size){
        Page<UserRes> userResPage = service.getAllPages(page, size);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.OK)
                        .message("User Page has been retrieved successfully")
                        .developerMessage("User Page has been retrieved successfully")
                        .data(Map.of("response", userResPage))
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> get(@PathVariable UUID id){
        UserRes userRes = service.getById(id);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.OK)
                        .message("User has been retrieved successfully")
                        .developerMessage("User has been retrieved successfully")
                        .data(Map.of("response", userRes))
                        .build()
        );
    }



    @GetMapping("")
    public ResponseEntity<HttpResponse> getAll(){
        List<UserRes>  userResList =  service.getAll();
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.OK)
                        .message("User List has been retrieved successfully")
                        .developerMessage("User List has been retrieved successfully")
                        .data(Map.of("response", userResList))
                        .build()
        );
    }

    @DeleteMapping("{id}")
    void deleteUser(@PathVariable UUID id) {
    }
}
