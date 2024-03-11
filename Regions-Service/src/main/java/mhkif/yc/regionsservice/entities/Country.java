package mhkif.yc.regionsservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Country {
    @Id
    private String Name;
    @Column(unique = true)
    private int world_number;

}
