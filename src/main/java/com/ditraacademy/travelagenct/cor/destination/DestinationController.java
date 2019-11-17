package com.ditraacademy.travelagenct.cor.destination;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DestinationController {

    @Autowired
    DestinationServices destinationServices;

    @PostMapping("/destination")
    public ResponseEntity<?> postDestination(@RequestBody Destination destination) {

        return destinationServices.postDestination(destination);
    }

    @GetMapping("/destinations")
    public List<Destination> getDestination() {
        return destinationServices.getDestination();

    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<?>  getDestinationById(@PathVariable int id) {
        return destinationServices.getDestinationById(id);

    }

    @PutMapping("/destination/{id}")
    public ResponseEntity<?> updateDestination(@RequestBody Destination destination,@PathVariable  int id) {
        return destinationServices.updateDestination(destination,id);

    }

    @DeleteMapping("/destination/{id}")
    public ResponseEntity<?> deleteDestinatnion(@PathVariable int id) {
        return destinationServices.deleteDestination(id);

    }




}
