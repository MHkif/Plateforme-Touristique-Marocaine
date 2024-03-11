package mhkif.yc.usersservice.dto.requests;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmailPasswordReq {
    @Valid

    @NotNull(message = "email field is required")
    @NotBlank(message = "email field is required")
    @Email(message = "this field must be a valid email")
    private String email;

    @NotNull(message = "password field is required")
    @Size(message = "Password must not be less than 6 & more than 26 chars", min = 6, max = 26)
    private String password;
}