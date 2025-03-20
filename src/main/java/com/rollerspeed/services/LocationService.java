package com.rollerspeed.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.dtos.LocationDTO;
import com.rollerspeed.mappers.LocationMapper;
import com.rollerspeed.models.Location;
import com.rollerspeed.models.enums.LocationStatus;
import com.rollerspeed.repositories.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LocationDTO> getLocationById(Long id) {
        return locationRepository.findById(id).map(locationMapper::toDTO);
    }

    public LocationDTO saveLocation(LocationDTO locationDTO) {
        Location location = locationMapper.toEntity(locationDTO);
        location.setStatus(LocationStatus.ACTIVE);
        return locationMapper.toDTO(locationRepository.save(location));
    }

    public LocationDTO updateLocation(Long id, LocationDTO locationDTO) {
        return locationRepository.findById(id).map(location -> {
            location.setName(locationDTO.getName());
            return locationMapper.toDTO(locationRepository.save(location));
        }).orElseThrow(() -> new IllegalArgumentException("Ubicación no encontrada con ID: " + id));
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
