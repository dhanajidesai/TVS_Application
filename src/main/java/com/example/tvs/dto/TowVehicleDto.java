package com.example.tvs.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


public class TowVehicleDto implements Serializable {

    private String vehicleNo;

    private String vehicleType;

    private String description;

    private String road;

    private String image;

    private String status;

    private Integer towedById;

    private Date updatedDate;

    private Integer lastUpdateById;
    
    private String policeStation;
    
    

    public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTowedById() {
        return towedById;
    }

    public void setTowedById(Integer towedById) {
        this.towedById = towedById;
    }


    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getLastUpdateById() {
        return lastUpdateById;
    }

    public void setLastUpdateById(Integer lastUpdateById) {
        this.lastUpdateById = lastUpdateById;
    }

	@Override
	public String toString() {
		return "TowVehicleDto [vehicleNo=" + vehicleNo + ", vehicleType=" + vehicleType + ", description=" + description
				+ ", road=" + road + ", image=" + image + ", status=" + status + ", towedById=" + towedById
				+ ", updatedDate=" + updatedDate + ", lastUpdateById=" + lastUpdateById + ", policeStation="
				+ policeStation + "]";
	}

   
    
}

