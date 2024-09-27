package com.rosan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
	private Integer id;
	private String name;
	private Double age;
	private String type;
}
