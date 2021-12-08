package com.example.tvs.service;

import java.util.List;
import java.util.Optional;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.PoliceStation;
import com.example.tvs.entity.User;
import com.example.tvs.entity.VehicalType;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;

public interface PoliceStationService {
	List<PoliceStation> getAllPoliceStations();
}
