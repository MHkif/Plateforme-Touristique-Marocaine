package mhkif.yc.regionsservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@Entity @Table(name = "activities")
public class Activity {

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

    private double period;
    private double price;
    private String webSite;
    private String telephone;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
