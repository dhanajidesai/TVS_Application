package com.example.tvs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "vehicleType")
@NamedQuery(name = "VehicalType.findAll", query = "SELECT v FROM VehicalType v")
public class VehicalType implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_type_id")
	private Long vehicleTypeId;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "descg")
	private String descg;
	
	@Column(name = "status")
	private String status;

	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescg() {
		return descg;
	}

	public void setDescg(String descg) {
		this.descg = descg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public VehicalType() {
		
	}

	public VehicalType(Long vehicleTypeId, String value, String descg, String status) {
		super();
		this.vehicleTypeId = vehicleTypeId;
		this.value = value;
		this.descg = descg;
		this.status = status;
	}
	
	

}
