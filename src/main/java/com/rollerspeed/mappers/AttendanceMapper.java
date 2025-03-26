package com.rollerspeed.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rollerspeed.dtos.AttendanceDTO;
import com.rollerspeed.models.Attendance;
import com.rollerspeed.models.ClassSchedule;
import com.rollerspeed.models.User;

@Component
public class AttendanceMapper {

    public AttendanceDTO toDTO(Attendance attendance) {
        return AttendanceDTO.builder()
                .id(attendance.getId())
                .attendanceDate(attendance.getAttendanceDate())
                .classScheduleId(attendance.getClassSchedule().getId())
                .presentStudentIds(attendance.getPresentStudents()
                        .stream()
                        .map(User::getId)
                        .collect(Collectors.toList()))
                .build();
    }

    public Attendance toEntity(AttendanceDTO dto, ClassSchedule classSchedule, List<User> students) {
        return Attendance.builder()
                .attendanceDate(dto.getAttendanceDate())
                .classSchedule(classSchedule)
                .presentStudents(students)
                .build();
    }
}
