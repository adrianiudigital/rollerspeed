package com.rollerspeed.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.dtos.TrainingLocationDTO;
import com.rollerspeed.mappers.TrainingLocationMapper;
import com.rollerspeed.models.TrainingLocation;
import com.rollerspeed.models.enums.TrainingLocationStatus;
import com.rollerspeed.repositories.TrainingLocationRepository;

@Service
public class TrainingLocationService {

    @Autowired
    private TrainingLocationRepository trainingLocationRepository;

    @Autowired
    private TrainingLocationMapper trainingLocationMapper;

    public List<TrainingLocationDTO> getAllLocations() {
        return trainingLocationRepository.findByStatus(TrainingLocationStatus.ACTIVE)
                .stream()
                .map(trainingLocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TrainingLocationDTO> getLocationById(Long id) {
        return trainingLocationRepository.findById(id)
                .map(trainingLocationMapper::toDTO);
    }

    public TrainingLocationDTO saveLocation(TrainingLocationDTO trainingLocationDTO) {
        TrainingLocation trainingLocation = trainingLocationMapper.toEntity(trainingLocationDTO);
        return trainingLocationMapper.toDTO(trainingLocationRepository.save(trainingLocation));
    }

    public TrainingLocationDTO updateLocation(Long id, TrainingLocationDTO trainingLocationDTO) {
        return trainingLocationRepository.findById(id)
                .map(existingLocation -> {
                    existingLocation.setName(trainingLocationDTO.getName());
                    existingLocation.setStatus(trainingLocationDTO.getStatus());
                    return trainingLocationMapper.toDTO(trainingLocationRepository.save(existingLocation));
                }).orElseThrow(() -> new IllegalArgumentException("Ubicación no encontrada con ID: " + id));
    }

    public void deleteLocationStatus(Long id) {
        if (!trainingLocationRepository.existsById(id)) {
            throw new IllegalArgumentException("Ubicación no encontrada con ID: " + id);
        }
        TrainingLocation trainingLocation = trainingLocationRepository.getReferenceById(id);
        if (trainingLocation.getStatus() != TrainingLocationStatus.DELETED) {
            trainingLocation.setStatus(TrainingLocationStatus.DELETED);
            trainingLocationRepository.save(trainingLocation);
        }
    }
}
