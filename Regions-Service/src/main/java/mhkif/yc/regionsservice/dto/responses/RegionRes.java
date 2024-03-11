package mhkif.yc.regionsservice.dto.responses;

import lombok.Data;
import java.util.UUID;

@Data
public class RegionRes {

    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    // TODO : Password should not be retrieved
    private String password;

}
