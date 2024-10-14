package com.fsd.assesment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.assesment.model.Hotel;
import com.fsd.assesment.service.HotelService;
import com.fsd.assesment.util.GlobalRepsonseHandler;

@RestController()
public class Controller {

	@Autowired
	private HotelService hotelService;

	@GetMapping(path = "/v1/hotel/index", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		return GlobalRepsonseHandler.generateRespone(hotelService.index(), "sucessfuly fetched hotels", HttpStatus.OK);
	}

	@PostMapping(path = "/v1/hotel/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
		return GlobalRepsonseHandler.generateRespone(hotelService.createhotel(hotel), "sucessfuly created hotel",
				HttpStatus.CREATED);
	}

	@PutMapping(path = "/v1/hotel/update/{hotelid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatehotel(@RequestBody Hotel hotel, @PathVariable long hotelid) {
		return GlobalRepsonseHandler.generateRespone(hotelService.updatehotel(hotel, hotelid),
				"sucessfuly updated hotel", HttpStatus.OK);
	}

	@DeleteMapping(path = "/v1/hotel/delete/{hotelid}")
	public ResponseEntity<?> deleteHotel(@PathVariable long hotelid) {
		return GlobalRepsonseHandler.generateRespone(hotelService.deleteHotel(hotelid), null, HttpStatus.OK);
	}
}
