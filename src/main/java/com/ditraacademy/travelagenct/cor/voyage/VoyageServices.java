package com.ditraacademy.travelagenct.cor.voyage;
import com.ditraacademy.travelagenct.cor.destination.Destination;
import com.ditraacademy.travelagenct.cor.destination.DestinationRepository;
import com.ditraacademy.travelagenct.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageServices {
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    DestinationRepository destinationRepository;

    public ResponseEntity<?> createVoyage( Voyage voyage) {

        Optional<Destination> OptionalDestination =destinationRepository.findById(voyage.getDestination().getId());
        if (!OptionalDestination.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong destination id"), HttpStatus.BAD_REQUEST);

        voyage = voyageRepository.save(voyage);
        return new ResponseEntity<>(voyage, HttpStatus.OK);

    }

    public ResponseEntity<?> getVoyages( ) {
       List<Voyage> voyages =voyageRepository.findAll();
        return new ResponseEntity<>(voyages, HttpStatus.OK);


    }

    public ResponseEntity<?> getVoyageById(int id) {
        Optional<Voyage> voyageOptional = voyageRepository.findById(id);
        if (!voyageOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong voyage id"), HttpStatus.BAD_REQUEST);

        Voyage voyage = voyageOptional.get();
        return new ResponseEntity<>(voyage, HttpStatus.OK);

    }

    public ResponseEntity<?> updateVoyage( Voyage voyage, int id) {
        Optional<Voyage> voyageOptional = voyageRepository.findById(id);
        if (!voyageOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong voyage id"), HttpStatus.BAD_REQUEST);

        Voyage voyageLegacy = voyageOptional.get();

        if(voyage.getTitre()!=null)
            voyageLegacy.setTitre(voyage.getTitre());

        if(voyage.getDescription()!=null)
            voyageLegacy.setDescription(voyage.getDescription());

        if(voyage.getDate()!=null)
            voyageLegacy.setDate(voyage.getDate());

        if(voyage.getNbPlaces()!=null)
            voyageLegacy.setNbPlaces(voyage.getNbPlaces());
        
        if(voyage.getPrix()!=null)
            voyageLegacy.setPrix(voyage.getPrix());

        voyageRepository.save(voyageLegacy);
        return new ResponseEntity<>( HttpStatus.OK);

    }

    public ResponseEntity<?> deleteVoyage( int id) {
        boolean voyageExist = voyageRepository.existsById(id);

        if(!voyageExist)
            return new ResponseEntity<>(new ErrorResponseModel("wrong voyage id"), HttpStatus.BAD_REQUEST);

        voyageRepository.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);

    }



}
