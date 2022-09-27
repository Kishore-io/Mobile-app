package com.wp.mobilephone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wp.mobilephone.model.Mobile;
import com.wp.mobilephone.service.MobileService;

@RestController
@RequestMapping("/mobiles")
public class MobileController {
	
	@Autowired
	private MobileService service;

	@PostMapping("/addMobile")
	public ResponseEntity<Mobile> saveMobile(@RequestBody Mobile mobile){
		Mobile savedMobile = service.saveMobile(mobile);
		
		if(savedMobile!=null) {
			return new ResponseEntity<Mobile>(savedMobile, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Mobile>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateMobile")
	public ResponseEntity<Mobile> updateMobile(@RequestBody Mobile mobile){
		Mobile updatedMobile = service.updateMobile(mobile);
		
		if(updatedMobile!=null) {
			return new ResponseEntity<Mobile>(updatedMobile, HttpStatus.OK);
		}
		
		return new ResponseEntity<Mobile>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllMobiles")
	public ResponseEntity<List<Mobile>> getAllMobiles(){
		List<Mobile> allMobiles = service.getAllMobiles();
		
		if(allMobiles.size()!=0) {
			return new ResponseEntity<List<Mobile>>(allMobiles,HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Mobile>>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<Mobile>> getMobileByBrand(@PathVariable String brand){
		List<Mobile> mobiles = service.findByBrand(brand);
		if(mobiles.size()!=0) {
			return new ResponseEntity<List<Mobile>>(mobiles,HttpStatus.OK);
		}
		return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/ime/{id}")
	public ResponseEntity<Mobile> getMobileByIme(@PathVariable int id){
		Mobile mobile = service.findByIme(id);
		if(mobile!=null) {
			return new ResponseEntity<Mobile>(mobile,HttpStatus.OK);
		}
		return new ResponseEntity<Mobile>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/processor/{processor}")
	public ResponseEntity<List<Mobile>> getMobileByProcessor(@PathVariable String processor){
		List<Mobile> mobiles = service.findByProcessor(processor);
		if(mobiles.size()!=0) {
			return new ResponseEntity<List<Mobile>>(mobiles,HttpStatus.OK);
		}
		return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/modelAndColor/{model}/{color}")
	public ResponseEntity<List<Mobile>> getMobileByModelAndColor(@PathVariable String model,@PathVariable String color){
		List<Mobile> mobiles = service.findByModelAndColor(model,color);
		if(mobiles.size()!=0) {
			return new ResponseEntity<List<Mobile>>(mobiles,HttpStatus.OK);
		}
		return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/getMobileByRange/{start}/{end}")
	public ResponseEntity<List<Mobile>> getMobileByModelAndColor(@PathVariable int start,@PathVariable int end){
		List<Mobile> mobiles = service.findByPriceRange(start, end);
		if(mobiles.size()!=0) {
			return new ResponseEntity<List<Mobile>>(mobiles,HttpStatus.OK);
		}
		return new ResponseEntity<List<Mobile>>(HttpStatus.NOT_FOUND);

	}
	
	@DeleteMapping("/delete/{ime}")
	public ResponseEntity<HttpStatus> deleteMobile(@PathVariable int ime){
		boolean deleted = service.deleteMobile(ime);
		if(!deleted) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
