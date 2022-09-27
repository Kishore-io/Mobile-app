package com.wp.mobilephone.service;

import java.util.List;

import com.wp.mobilephone.model.Mobile;

public interface MobileService {

	public Mobile saveMobile(Mobile mobile);
	
	public Mobile updateMobile(Mobile mobile);
	
	public List<Mobile> getAllMobiles();
	
	public Mobile findByIme(int ime);
	
	public List<Mobile> findByPriceRange(int start,int end);
	
	public List<Mobile> findByBrand(String brand);
	
	public List<Mobile> findByColor(String color);
	
	public List<Mobile> findByModelAndColor(String model,String color);
	
	public List<Mobile> findByProcessor(String processor);
	
	public boolean deleteMobile(int ime);
	
	
}
