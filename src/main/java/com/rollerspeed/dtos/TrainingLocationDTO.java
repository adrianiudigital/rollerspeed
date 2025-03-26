package com.rollerspeed.dtos;

import com.rollerspeed.models.enums.TrainingLocationStatus;

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
public class TrainingLocationDTO {
    private Long id;
    private String name;
    private TrainingLocationStatus status;
}
