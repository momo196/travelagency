package com.ditraacademy.travelagenct.cor.voyage;

import com.ditraacademy.travelagenct.cor.destination.Destination;
import com.ditraacademy.travelagenct.utils.Audible;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Where(clause = "deleted =false")
@SQLDelete(sql = "update voyage set deleted=true where id = ?")
public class Voyage extends Audible<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String titre;

    @Column(columnDefinition = "text")
    private  String description;

    private Date date ;

    private Integer nbPlaces ;

    private  Double prix;

    @ManyToOne
    private Destination destination;
    @JsonIgnore
    private  boolean deleted = false;

}
