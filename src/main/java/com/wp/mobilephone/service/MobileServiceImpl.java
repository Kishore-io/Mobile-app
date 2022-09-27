package com.wp.mobilephone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.mobilephone.exception.MobileAlreadyExistsException;
import com.wp.mobilephone.model.Mobile;
import com.wp.mobilephone.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService{
	
	@Autowired
	private MobileRepository repo;

	@Override
	public Mobile saveMobile(Mobile mobile) {
		Optional<Mobile> mob = repo.findById(mobile.getIME());
		if(mob.isPresent()) {
			throw new MobileAlreadyExistsException("IME with mobile already exits");
		}
		return repo.save(mobile);
	}

	@Override
	public Mobile updateMobile(Mobile mobile) {
		return repo.save(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() {
		return repo.findAll();
	}

	@Override
	public List<Mobile> findByBrand(String brand) {
		return repo.findMobileByBrand(brand);
	}

	@Override
	public List<Mobile> findByColor(String color) {
		return repo.findMobileByColor(color);
	}

	@Override
	public List<Mobile> findByModelAndColor(String model, String color) {
		return repo.findMobileByModelAndColor(model, color);
	}

	@Override
	public List<Mobile> findByProcessor(String processor) {
		return repo.findMobileByProcessor(processor);
	}

	@Override
	public boolean deleteMobile(int ime) {
		Optional<Mobile> mob = repo.findById(ime);
		if(mob.get()!=null) {
			repo.deleteById(ime);
			return true;
		}
		return false;
	}

	@Override
	public Mobile findByIme(int ime) {
		return repo.findById(ime).get();
	}

	@Override
	public List<Mobile> findByPriceRange(int start, int end) {
		return repo.findMobileByPriceBetween(start, end);
	}

}
