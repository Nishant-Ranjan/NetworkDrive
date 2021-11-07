package com.example.sample.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.example.sample.constants.ConnectionStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Drives")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Drive {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "drive_name")
	private String driveName;
	
	@Column(name = "server_name")
	private String serverName;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "connection_status")
	private ConnectionStatus connectionStatus;
	
	@PrePersist
	private void prepersist() {
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}
}
