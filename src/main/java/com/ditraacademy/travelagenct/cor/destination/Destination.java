package com.ditraacademy.travelagenct.cor.destination;


import com.ditraacademy.travelagenct.cor.voyage.Voyage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy="destination")
    private List<Voyage> voyageList;
}
