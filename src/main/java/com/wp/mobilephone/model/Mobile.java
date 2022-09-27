package com.wp.mobilephone.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mobile {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IME;
	
	private String model;
	
	private String brand;
	
	private String color;
	

	private int price;
	
	private String processor;
	
	private String camera;
}
