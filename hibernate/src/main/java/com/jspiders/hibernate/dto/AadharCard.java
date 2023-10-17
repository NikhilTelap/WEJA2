package com.jspiders.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AadharCard {
	@Id
	private int id;
	private long aadharNumber;
	private String dateOfIssue;

}
