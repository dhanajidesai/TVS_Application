package com.example.tvs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tow_vehicle")
public class TowVehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vehicleNo;

    private String vehicleType;

    private String description;

    private String road;

    private String image;

    private String status;

    private Integer towedById;

    private Date createdDate;

    private Date updatedDate;

    private Integer lastUpdateById;
    
    private String policeStation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
    

    public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public TowVehicle() {
    }

    public TowVehicle(Long id, String vehicleNo, String vehicleType, String description, String road, String image, String status, Integer towedById, Date createdDate, Date updatedDate, Integer lastUpdateById, String policeStation) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.description = description;
        this.road = road;
        this.image = image;
        this.status = status;
        this.towedById = towedById;
        this.createdDate = new Date();
        this.updatedDate = new Date();
        this.lastUpdateById = lastUpdateById;
        this.policeStation=policeStation;
    }

    public TowVehicle(String vehicleNo, String vehicleType, String description, String road, String image, String status, Integer towedById, Date createdDate, Integer lastUpdateById,Date updatedDate,String policeStation) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.description = description;
        this.road = road;
        this.image = image;
        this.status = status;
        this.towedById = towedById;
        this.createdDate = createdDate;
        this.lastUpdateById = lastUpdateById;
        this.updatedDate = updatedDate;
        this.policeStation=policeStation;
    }

	@Override
	public String toString() {
		return "TowVehicle [id=" + id + ", vehicleNo=" + vehicleNo + ", vehicleType=" + vehicleType + ", description="
				+ description + ", road=" + road + ", image=" + image + ", status=" + status + ", towedById="
				+ towedById + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", lastUpdateById="
				+ lastUpdateById + ", policeStation=" + policeStation + "]";
	}

   
    
}
