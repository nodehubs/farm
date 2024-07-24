package com.example.farmlandmonitoring.controller;

import com.example.farmlandmonitoring.model.SensorData;
import com.example.farmlandmonitoring.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SensorDataController {

    @Autowired
    private SensorDataRepository sensorDataRepository;
    private static final Logger logger = LoggerFactory.getLogger(SensorDataController.class);

    private final RestTemplate restTemplate = new RestTemplate();
    private final String carControlUrl = "http://10.255.18.103:5000/api/control";

    @PostMapping("/data")
    @Transactional
    public SensorData receiveData(@RequestBody SensorData sensorData) {
        logger.info("Received data: {}", sensorData);
        return sensorDataRepository.save(sensorData);
    }

    @GetMapping("/data")
    public List<SensorData> getAllData() {
        return sensorDataRepository.findAll();
    }



    @PostMapping("/control")
    public String controlCar(@RequestParam String action) {
        String url = carControlUrl + "?action=" + action;
        try {
            restTemplate.postForObject(url, null, String.class);
            return "Action " + action + " sent successfully.";
        } catch (Exception e) {
            return "Failed to send action " + action + ": " + e.getMessage();
        }
    }
}


