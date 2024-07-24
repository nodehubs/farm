package com.example.farmlandmonitoring.repository;

import com.example.farmlandmonitoring.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
}
