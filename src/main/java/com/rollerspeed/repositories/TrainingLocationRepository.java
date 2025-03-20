package com.rollerspeed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.models.TrainingLocation;

@Repository
public interface TrainingLocationRepository extends JpaRepository<TrainingLocation, Long> {
}
