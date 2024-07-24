package com.example.farmlandmonitoring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("humidity")
    private double humidity;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("diseaseInfo")
    private String diseaseInfo;

    @JsonProperty("diseaseCount")
    private int diseaseCount;


    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDiseaseInfo() {
        return diseaseInfo;
    }

    public int getDiseaseCount() {
        return diseaseCount;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "timestamp='" + timestamp + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", diseaseInfo='" + diseaseInfo + '\'' +
                ", diseaseCount=" + diseaseCount +
                '}';
    }
}
