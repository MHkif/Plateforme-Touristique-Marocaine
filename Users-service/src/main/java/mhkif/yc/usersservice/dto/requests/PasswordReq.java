package mhkif.yc.usersservice.dto.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PasswordReq {
    @NotNull(message = "password field is required")
    @Size(message = "Password must not be less than 6 & more than 26 chars", min = 6, max = 26)
    private String password;
}
