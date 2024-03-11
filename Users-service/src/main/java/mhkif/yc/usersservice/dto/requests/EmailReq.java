package mhkif.yc.usersservice.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailReq {
    @NotNull(message = "email field is required")
    @NotBlank(message = "email field is required")
    @Email(message = "this field must be a valid email")
    private String email;
}
