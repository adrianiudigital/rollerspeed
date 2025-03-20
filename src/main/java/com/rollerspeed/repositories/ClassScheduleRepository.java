package com.rollerspeed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.models.ClassSchedule;
import com.rollerspeed.models.enums.ClassStatus;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
    List<ClassSchedule> findByStatusNot(ClassStatus status);
}
