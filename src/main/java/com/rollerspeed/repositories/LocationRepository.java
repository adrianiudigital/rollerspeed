package com.rollerspeed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
