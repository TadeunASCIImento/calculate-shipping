package com.rest.calculate.shipping.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.calculate.shipping.bean.Cep;
import com.rest.calculate.shipping.service.AddressService;

@RestController
@RequestMapping("/calculate")
public class CalculateShippingController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(method = GET, value = "/shipping", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> calculateShipping(@RequestBody Cep cep) throws Exception {
		try {
			return new ResponseEntity<>(addressService.getAddressByCep(cep.getCep()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error calculating shipping", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
