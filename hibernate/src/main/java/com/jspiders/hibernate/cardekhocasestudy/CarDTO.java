package com.jspiders.hibernate.cardekhocasestudy;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class CarDTO {
	
		@Id
		private int car_id;
		private String name;
		private String brand;
		private String fuel_type;
		private long price;
	}


