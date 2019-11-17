package com.ditraacademy.travelagenct.cor.voyage;

import com.ditraacademy.travelagenct.cor.destination.Destination;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String titre;

    private  String description;

    private Date date ;

    private Integer nbPlaces ;

    private  Double prix;

    @ManyToOne
    private Destination destination;

}
