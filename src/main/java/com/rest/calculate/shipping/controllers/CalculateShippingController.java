package com.rest.calculate.shipping.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.bean.Cep;
import com.rest.calculate.shipping.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/calculate")
public class CalculateShippingController {

	@Autowired
	private AddressService addrService;

	@RequestMapping(method = GET, value = "/shipping", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> calculateShipping(@RequestBody Cep cep) throws Exception {
		try {
			Address address = addrService.getAddressByCep(cep.getCep());
			if (address.isErro()) {
				log.info("[INFO]: Zip code not found.");
				return new ResponseEntity<>("[INFO]: Zip code not found.", HttpStatus.OK);
			}
			return new ResponseEntity<>(addrService.calculateShippingValueByAddress(address), HttpStatus.OK);
		} catch (Exception e) {
			log.error("[Error] Calculating shipping",e.getMessage(), e);
			return new ResponseEntity<>("[Error] Calculating shipping", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
