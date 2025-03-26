package com.rollerspeed.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rollerspeed.dtos.TrainingLocationDTO;
import com.rollerspeed.services.TrainingLocationService;

@RestController
@RequestMapping("${api.base-path}/locations")
public class TrainingLocationController {

    @Autowired
    private TrainingLocationService trainingLocationService;

    @GetMapping
    public List<TrainingLocationDTO> getAllLocations() {
        return trainingLocationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingLocationDTO> getLocationById(@PathVariable Long id) {
        Optional<TrainingLocationDTO> location = trainingLocationService.getLocationById(id);
        return location.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrainingLocationDTO> createLocation(@RequestBody TrainingLocationDTO trainingLocationDTO) {
        return ResponseEntity.ok(trainingLocationService.saveLocation(trainingLocationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingLocationDTO> updateLocation(@PathVariable Long id,
            @RequestBody TrainingLocationDTO trainingLocationDTO) {
        return ResponseEntity.ok(trainingLocationService.updateLocation(id, trainingLocationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        trainingLocationService.deleteLocationStatus(id);
        return ResponseEntity.noContent().build();
    }
}
