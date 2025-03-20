package com.rollerspeed.dtos;

import java.time.LocalDateTime;

import com.rollerspeed.models.TrainingLocation;
import com.rollerspeed.models.enums.ClassStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassScheduleDTO {
    private Long id;
    private LocalDateTime classDate;
    private String level;
    private Long instructorId;
    private TrainingLocation trainingLocation;
    private ClassStatus status;
}
