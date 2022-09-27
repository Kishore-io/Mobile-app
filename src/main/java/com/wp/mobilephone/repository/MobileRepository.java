package com.wp.mobilephone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wp.mobilephone.model.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer>{

	List<Mobile> findMobileByBrand(String brand);
	
	List<Mobile> findMobileByColor(String color);
	
	List<Mobile> findMobileByModelAndColor(String model,String color);
	
	List<Mobile> findMobileByProcessor(String processor);
	
	List<Mobile> findMobileByPriceBetween(int start,int end);
	
	

//    List<Mobile> findMobileByCameraGreaterThanEqual(byte camera);

//    List<Mobile> findMobileByMakerIgnoreCaseAndColorIgnoreCase(String maker,String color);
	
	
}
