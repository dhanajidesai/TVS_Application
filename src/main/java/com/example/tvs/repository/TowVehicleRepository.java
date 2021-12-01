package com.example.tvs.repository;

import com.example.tvs.entity.TowVehicle;
import com.example.tvs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TowVehicleRepository extends JpaRepository<TowVehicle, Long> {

    TowVehicle save(TowVehicle towVehicle);

    @Query(value = "select * from tow_vehicle where id = ?", nativeQuery = true)
    TowVehicle findTowVehicleById(Long id);

}
