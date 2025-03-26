package com.rollerspeed.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.dtos.AttendanceDTO;
import com.rollerspeed.mappers.AttendanceMapper;
import com.rollerspeed.models.Attendance;
import com.rollerspeed.models.ClassSchedule;
import com.rollerspeed.models.User;
import com.rollerspeed.repositories.AttendanceRepository;
import com.rollerspeed.repositories.ClassScheduleRepository;
import com.rollerspeed.repositories.UserRepository;

@Service
public class AttendanceService {

        @Autowired
        private AttendanceRepository attendanceRepository;

        @Autowired
        private ClassScheduleRepository classScheduleRepository;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private AttendanceMapper attendanceMapper;

        public AttendanceDTO registerAttendance(Long classId, AttendanceDTO dto) {
                ClassSchedule classSchedule = classScheduleRepository.findById(classId)
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "Clase no encontrada con ID: " + classId));

                List<User> students = dto.getPresentStudentIds().stream()
                                .map(id -> userRepository.findById(id)
                                                .orElseThrow(() -> new IllegalArgumentException(
                                                                "Estudiante no encontrado con ID: " + id)))
                                .collect(Collectors.toList());

                if (dto.getAttendanceDate() == null) {
                        dto.setAttendanceDate(LocalDateTime.now());
                }

                Attendance attendance = attendanceMapper.toEntity(dto, classSchedule, students);
                return attendanceMapper.toDTO(attendanceRepository.save(attendance));
        }

        public List<AttendanceDTO> getAttendanceByStudent(Long studentId) {
                User student = userRepository.findById(studentId)
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "Estudiante no encontrado con ID: " + studentId));

                return attendanceRepository.findByPresentStudentsContaining(student)
                                .stream()
                                .map(attendanceMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public List<AttendanceDTO> getAttendanceByClass(Long classId) {
                ClassSchedule classSchedule = classScheduleRepository.findById(classId)
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "Clase no encontrada con ID: " + classId));

                return attendanceRepository.findByClassSchedule(classSchedule)
                                .stream()
                                .map(attendanceMapper::toDTO)
                                .collect(Collectors.toList());
        }
}
