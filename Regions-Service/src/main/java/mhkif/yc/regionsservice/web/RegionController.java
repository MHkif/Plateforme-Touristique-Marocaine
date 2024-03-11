package mhkif.yc.regionsservice.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mhkif.yc.regionsservice.dto.HttpResponse;
import mhkif.yc.regionsservice.dto.requests.RegionReq;
import mhkif.yc.regionsservice.dto.responses.RegionRes;
import mhkif.yc.regionsservice.services.RegionService;
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
@RequestMapping("tourism/api/v1/regions")
@RequiredArgsConstructor
public class RegionController {


    private final RegionService service;
    private final ModelMapper mapper;


    @PostMapping("")
    public ResponseEntity<HttpResponse> save(@Valid @RequestBody RegionReq request){
        RegionRes user = service.create(request);
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
    public ResponseEntity<HttpResponse> update(@RequestBody RegionRes user, @PathVariable int id) {

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
        Page<RegionRes> userResPage = service.getAllPages(page, size);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.OK)
                        .message("Region Page has been retrieved successfully")
                        .developerMessage("Region Page has been retrieved successfully")
                        .data(Map.of("response", userResPage))
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<HttpResponse> get(@PathVariable int id){
        RegionRes regionRes = service.getById(id);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/save")
                        .status(HttpStatus.OK)
                        .message("Region has been retrieved successfully")
                        .developerMessage("Region has been retrieved successfully")
                        .data(Map.of("response", regionRes))
                        .build()
        );
    }



    @GetMapping("")
    public ResponseEntity<HttpResponse> getAll(){
        List<RegionRes>  regionResList =  service.getAll();
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .statusCode(HttpStatus.CREATED.value())
                        .path("tourism/api/v1/getAll")
                        .status(HttpStatus.OK)
                        .message("Region List has been retrieved successfully")
                        .developerMessage("Region List has been retrieved successfully")
                        .data(Map.of("response", regionResList))
                        .build()
        );
    }

    @DeleteMapping("{id}")
    void deleteUser(@PathVariable UUID id) {
    }
}
