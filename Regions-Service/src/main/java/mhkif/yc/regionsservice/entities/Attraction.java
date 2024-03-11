package mhkif.yc.regionsservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@Entity @Table(name = "attractions")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private String image;
    private String type;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    private String address;
    private String webSite;
    private String telephone;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}