package com.rollerspeed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.models.Attendance;
import com.rollerspeed.models.ClassSchedule;
import com.rollerspeed.models.User;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByClassSchedule(ClassSchedule classSchedule);

    List<Attendance> findByPresentStudentsContaining(User student);
}
