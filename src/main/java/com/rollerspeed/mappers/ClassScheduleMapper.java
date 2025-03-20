package com.rollerspeed.mappers;

import org.springframework.stereotype.Component;

import com.rollerspeed.dtos.ClassScheduleDTO;
import com.rollerspeed.models.ClassSchedule;
import com.rollerspeed.models.TrainingLocation;
import com.rollerspeed.models.User;

@Component
public class ClassScheduleMapper {

    public ClassScheduleDTO toDTO(ClassSchedule classSchedule) {
        return ClassScheduleDTO.builder()
                .id(classSchedule.getId())
                .classDate(classSchedule.getClassDate())
                .level(classSchedule.getLevel())
                .instructorId(classSchedule.getInstructor().getId())
                .trainingLocation(classSchedule.getTrainingLocation())
                .status(classSchedule.getStatus())
                .build();
    }

    public ClassSchedule toEntity(ClassScheduleDTO classScheduleDTO, User instructor, TrainingLocation location) {
        return ClassSchedule.builder()
                .classDate(classScheduleDTO.getClassDate())
                .level(classScheduleDTO.getLevel())
                .instructor(instructor)
                .trainingLocation(location)
                .status(classScheduleDTO.getStatus())
                .build();
    }
}
