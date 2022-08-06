package com.customerApp.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cust2")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cust_id;
	@NotEmpty(message = "Name can't be blank")
	private String cust_name;
	@NotEmpty(message = "Gender can't be blank")
	private String cust_gender;
	@NotEmpty(message = "Martial Status can't be blank")
	private String cust_martial_status;
	@NotEmpty(message = "Address can't be blank")
	private String cust_address;

}
