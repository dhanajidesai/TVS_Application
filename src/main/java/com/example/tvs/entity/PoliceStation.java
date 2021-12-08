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
@Table(name = "police_station")
@NamedQuery(name = "PoliceStation.findAll", query = "SELECT p FROM PoliceStation p")
public class PoliceStation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "police_station_id")
	private Long policeStationId;

	@Column(name = "value")
	private String value;

	@Column(name = "descg")
	private String descg;

	@Column(name = "status")
	private String status;



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



	public Long getPoliceStationId() {
		return policeStationId;
	}

	public void setPoliceStationId(Long policeStationId) {
		this.policeStationId = policeStationId;
	}

	public PoliceStation() {

	}

	public PoliceStation(Long policeStationId, String value, String descg, String status) {
		super();
		this.policeStationId = policeStationId;
		this.value = value;
		this.descg = descg;
		this.status = status;
	}





}
