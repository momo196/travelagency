package com.ditraacademy.travelagenct.cor.voyage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoyageRepository extends JpaRepository <Voyage,Integer> {
    public List <Voyage> findAllByPrixIsBetweenAndNbPlacesIsNot(double min,double max,int nbPlaces);
    @Query(value = " select  * from voyage where nb_places = ?1 ",nativeQuery = true)
    public List<Voyage> findAllByQuery(@Param("nb") int nb);
}
