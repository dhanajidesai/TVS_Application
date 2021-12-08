package com.example.tvs.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tvs.entity.PoliceStation;
import com.example.tvs.entity.User;
import com.example.tvs.entity.VehicalType;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {
	
}
