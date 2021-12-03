package com.example.tvs.repository;

import com.example.tvs.entity.TowVehicle;
import com.example.tvs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TowVehicleRepository extends JpaRepository<TowVehicle, Long> {

    TowVehicle save(TowVehicle towVehicle);

    @Query(value = "select * from tow_vehicle where id = ?", nativeQuery = true)
    TowVehicle findTowVehicleById(Long id);
    
    @Query(value = "select * from tow_vehicle where status = ? ORDER BY updated_date DESC", nativeQuery = true)
    List<TowVehicle> findTowVehicleBystatus(String status);
    
    @Query(value = "select * from tow_vehicle where vehicle_no = ? ORDER BY updated_date DESC LIMIT 1", nativeQuery = true)
    Optional<TowVehicle> findByVehicleNo(String vehicleNo);

}
