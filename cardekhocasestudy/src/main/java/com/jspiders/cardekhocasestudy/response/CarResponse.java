package com.jspiders.cardekhocasestudy.response;

import java.util.List;

import com.jspiders.cardekhocasestudy.pojo.CarPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {

	private String msg;
	private CarPOJO car;
	List<CarPOJO> cars;
}
