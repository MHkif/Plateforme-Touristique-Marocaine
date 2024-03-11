package mhkif.yc.usersservice.dto.responses;

import lombok.Data;
import mhkif.yc.usersservice.enums.Role;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserRes {

    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    // TODO : Password should not be retrieved
    private String password;
    private boolean isEnabled;
    private Role role;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

}
