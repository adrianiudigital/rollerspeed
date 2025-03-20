package com.rollerspeed.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rollerspeed.dtos.ClassScheduleDTO;
import com.rollerspeed.services.ClassScheduleService;

@RestController
@RequestMapping("${api.classes.base}")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classScheduleService;

    @GetMapping
    public List<ClassScheduleDTO> getAllClasses() {
        return classScheduleService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassScheduleDTO> getClassById(@PathVariable Long id) {
        Optional<ClassScheduleDTO> classSchedule = classScheduleService.getClassById(id);
        return classSchedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClassScheduleDTO> createClass(@RequestBody ClassScheduleDTO classScheduleDTO) {
        return ResponseEntity.ok(classScheduleService.saveClass(classScheduleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassScheduleDTO> updateClass(@PathVariable Long id,
            @RequestBody ClassScheduleDTO classScheduleDTO) {
        return ResponseEntity.ok(classScheduleService.updateClass(id, classScheduleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classScheduleService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}
