package com.rollerspeed.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.dtos.ClassScheduleDTO;
import com.rollerspeed.mappers.ClassScheduleMapper;
import com.rollerspeed.models.ClassSchedule;
import com.rollerspeed.models.TrainingLocation;
import com.rollerspeed.models.User;
import com.rollerspeed.repositories.ClassScheduleRepository;
import com.rollerspeed.repositories.TrainingLocationRepository;
import com.rollerspeed.repositories.UserRepository;

@Service
public class ClassScheduleService {

    @Autowired
    private ClassScheduleRepository classScheduleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainingLocationRepository locationRepository;

    @Autowired
    private ClassScheduleMapper classScheduleMapper;

    public List<ClassScheduleDTO> getAllClasses() {
        return classScheduleRepository.findAll()
                .stream()
                .map(classScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ClassScheduleDTO> getClassById(Long id) {
        return classScheduleRepository.findById(id)
                .map(classScheduleMapper::toDTO);
    }

    public ClassScheduleDTO saveClass(ClassScheduleDTO classScheduleDTO) {
        User instructor = userRepository.findById(classScheduleDTO.getInstructorId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Instructor no encontrado con ID: " + classScheduleDTO.getInstructorId()));

        TrainingLocation location = locationRepository.findById(classScheduleDTO.getLocationId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ubicación no encontrada con ID: " + classScheduleDTO.getLocationId()));

        ClassSchedule classSchedule = classScheduleMapper.toEntity(classScheduleDTO, instructor, location);
        return classScheduleMapper.toDTO(classScheduleRepository.save(classSchedule));
    }

    public ClassScheduleDTO updateClass(Long id, ClassScheduleDTO classScheduleDTO) {
        return classScheduleRepository.findById(id).map(classSchedule -> {
            User instructor = userRepository.findById(classScheduleDTO.getInstructorId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Instructor no encontrado con ID: " + classScheduleDTO.getInstructorId()));

            TrainingLocation location = locationRepository.findById(classScheduleDTO.getLocationId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Ubicación no encontrada con ID: " + classScheduleDTO.getLocationId()));

            classSchedule.setClassDate(classScheduleDTO.getClassDate());
            classSchedule.setLevel(classScheduleDTO.getLevel());
            classSchedule.setInstructor(instructor);
            classSchedule.setLocation(location);
            classSchedule.setStatus(classScheduleDTO.getStatus());

            return classScheduleMapper.toDTO(classScheduleRepository.save(classSchedule));
        }).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada con ID: " + id));
    }

    public void deleteClass(Long id) {
        if (!classScheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró la clase con ID: " + id);
        }
        classScheduleRepository.deleteById(id);
    }
}
