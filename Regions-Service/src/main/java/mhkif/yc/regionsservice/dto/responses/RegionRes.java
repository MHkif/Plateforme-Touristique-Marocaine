package mhkif.yc.regionsservice.dto.responses;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mhkif.yc.regionsservice.entities.Country;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RegionRes {

    private int id;
    private String name;
    /*
    private String description;
    private String image;
    private double latitude;
    private double longitude;

     */
    private Country country;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
