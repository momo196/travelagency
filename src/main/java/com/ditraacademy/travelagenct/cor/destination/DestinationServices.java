package com.ditraacademy.travelagenct.cor.destination;

import com.ditraacademy.travelagenct.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DestinationServices {
    @Autowired
    DestinationRepository destinationRepository;

    public ResponseEntity<?> postDestination(Destination destination) {

        destination = destinationRepository.save(destination);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    public List<Destination> getDestination( ) {

        return destinationRepository.findAll();
    }

    public ResponseEntity<?> getDestinationById( int id) {
        Optional<Destination> destinationOptional = destinationRepository.findById(id);
        if (!destinationOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong destination id"), HttpStatus.BAD_REQUEST);

        Destination destination = destinationOptional.get();
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    public ResponseEntity<?> updateDestination( Destination destination,int id) {

        Optional<Destination> destinationOptional = destinationRepository.findById(id);
        if (!destinationOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong destination id"), HttpStatus.BAD_REQUEST);

        Destination destinationLegacy = destinationOptional.get();
        
        if(destination.getNom()!=null)
            destinationLegacy.setNom(destination.getNom());

        if(destination.getDescription()!=null)
            destinationLegacy.setDescription(destination.getDescription());

        destinationRepository.save(destinationLegacy);
        return new ResponseEntity<>( HttpStatus.OK);

    }

    public ResponseEntity<?> deleteDestination( int id) {

        boolean destinationExist = destinationRepository.existsById(id);

        if(!destinationExist)
            return new ResponseEntity<>(new ErrorResponseModel("wrong destination id"), HttpStatus.BAD_REQUEST);

        destinationRepository.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);

    }

}
