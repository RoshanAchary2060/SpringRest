package com.rosan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "REST_TOURIST")
public class Tourist implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	
	@NonNull
	@Column(length = 20)
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String city;
	@NonNull
	@Column(length = 20)
	private String packageType;
	@NonNull
	private Double budget;
}
