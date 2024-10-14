package com.fsd.assesment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.assesment.model.Hotel;
import com.fsd.assesment.repository.HotelRepository;
import com.fsd.assesment.util.ResourceNotFoundException;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	public List<Hotel> index() {
		List<Hotel> hotels = Optional.ofNullable(hotelRepository.findAll())
				.orElseThrow(() -> new ResourceNotFoundException("No hotels found"));
		return hotels;
	}

	public Hotel createhotel(Hotel hotel) {
		try {
			hotel.setIsactive(1);
			return hotelRepository.save(hotel);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Hotel updatehotel(Hotel hotel, long hotelId) {
		try {
			Hotel existinghotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("No hotels found for hotel_id: "+hotelId));
			BeanUtils.copyProperties(hotel, existinghotel);
		return existinghotel;
		} catch (Exception e) {
			throw e;
		}
//		 hotelRepository.findById(hotelId).ifPresentOrElse(ee->{
//			BeanUtils.copyProperties(hotel, ee);
//			return ee;
//		}, () -> new ResourceNotFoundException("No hotels found for hotel_id: "+hotelId));
	}
	
	public String deleteHotel(Long hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("No hotels found for hotel_id: "+hotelId));
		hotel.setIsactive(0);
		return "sucessfully deleted hotel";
	}
	

}
