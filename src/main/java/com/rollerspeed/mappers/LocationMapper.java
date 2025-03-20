package com.rollerspeed.mappers;

import org.springframework.stereotype.Component;

import com.rollerspeed.dtos.LocationDTO;
import com.rollerspeed.models.Location;

@Component
public class LocationMapper {

    public LocationDTO toDTO(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .build();
    }

    public Location toEntity(LocationDTO locationDTO) {
        return Location.builder()
                .name(locationDTO.getName())
                .build();
    }
}
