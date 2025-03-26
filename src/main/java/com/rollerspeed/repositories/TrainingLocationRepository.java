package com.rollerspeed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.models.TrainingLocation;
import com.rollerspeed.models.enums.TrainingLocationStatus;

@Repository
public interface TrainingLocationRepository extends JpaRepository<TrainingLocation, Long> {
    List<TrainingLocation> findByStatus(TrainingLocationStatus status);
}
