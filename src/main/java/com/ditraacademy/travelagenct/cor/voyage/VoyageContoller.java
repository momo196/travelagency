package com.ditraacademy.travelagenct.cor.voyage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoyageContoller {
    @Autowired
    VoyageServices voyageServices;

    @PostMapping("/voyage")
    public ResponseEntity<?> createVoyage(@RequestBody Voyage voyage) {
        return voyageServices.createVoyage(voyage);
    }

    @GetMapping("/voyages")
    public ResponseEntity<?> getVoyages() {
        return voyageServices.getVoyages();

    }

    @GetMapping("/voyage/{id}")
    public ResponseEntity<?> getVoyageById(@PathVariable int id) {
        return voyageServices.getVoyageById(id);

    }

    @PutMapping("/voyage/{id}")
    public ResponseEntity<?> updateVoyage(@RequestBody Voyage voyage,@PathVariable int id) {
        return voyageServices.updateVoyage(voyage,id);

    }

    @DeleteMapping("voyage/{id}")
    public ResponseEntity<?> deleteVoyage(@PathVariable int id) {
        return voyageServices.deleteVoyage(id);

    }








}
