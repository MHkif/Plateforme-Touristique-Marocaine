package mhkif.yc.usersservice.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Region {

    private int id;
    private String name;
    //private Country country;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;


}