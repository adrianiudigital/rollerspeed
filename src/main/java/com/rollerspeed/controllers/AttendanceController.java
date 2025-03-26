package com.rollerspeed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rollerspeed.dtos.AttendanceDTO;
import com.rollerspeed.services.AttendanceService;

@RestController
@RequestMapping("${api.base-path}/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/{classId}/register")
    public ResponseEntity<AttendanceDTO> registerAttendance(@PathVariable Long classId,
            @RequestBody AttendanceDTO dto) {
        return ResponseEntity.ok(attendanceService.registerAttendance(classId, dto));
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<AttendanceDTO>> getAttendanceByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(attendanceService.getAttendanceByStudent(studentId));
    }

    @GetMapping("/classes/{classId}")
    public ResponseEntity<List<AttendanceDTO>> getAttendanceByClass(@PathVariable Long classId) {
        return ResponseEntity.ok(attendanceService.getAttendanceByClass(classId));
    }
}
