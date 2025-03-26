package com.rollerspeed.mappers;

import org.springframework.stereotype.Component;
import com.rollerspeed.dtos.TrainingLocationDTO;
import com.rollerspeed.models.TrainingLocation;

@Component
public class TrainingLocationMapper {

    public TrainingLocationDTO toDTO(TrainingLocation trainingLocation) {
        return TrainingLocationDTO.builder()
                .id(trainingLocation.getId())
                .name(trainingLocation.getName())
                .status(trainingLocation.getStatus())
                .build();
    }

    public TrainingLocation toEntity(TrainingLocationDTO trainingLocationDTO) {
        return TrainingLocation.builder()
                .id(trainingLocationDTO.getId())
                .name(trainingLocationDTO.getName())
                .status(trainingLocationDTO.getStatus())
                .build();
    }
}
