package mhkif.yc.regionsservice.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter @Setter
@Entity @Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private String image;
    private double latitude;
    private double longitude;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}