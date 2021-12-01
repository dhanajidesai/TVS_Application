package com.example.tvs.service;

import com.example.tvs.dto.TowVehicleDto;
import com.example.tvs.entity.TowVehicle;
import com.example.tvs.exception.ResourceNotFoundException;

import java.util.Optional;

public interface TowVehicleService {
    TowVehicle save(TowVehicleDto towVehicleDto);
    TowVehicle update(Long id, TowVehicleDto towVehicleDto) throws ResourceNotFoundException;
    Optional<TowVehicle> findById(Long id) throws ResourceNotFoundException;
}
