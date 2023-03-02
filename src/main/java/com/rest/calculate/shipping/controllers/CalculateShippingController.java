package com.rest.calculate.shipping.controllers;

import static com.rest.calculate.shipping.controllers.constants.CalculateShippingControllerConstants.END_POINT_CALCULATE_SHIPPING;
import static com.rest.calculate.shipping.controllers.constants.CalculateShippingControllerConstants.MSG_ERROR_CALCULATING_SHIPPING;
import static com.rest.calculate.shipping.controllers.constants.CalculateShippingControllerConstants.MSG_INFO_ZIP_CODE_NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.bean.Cep;
import com.rest.calculate.shipping.bean.InvalidInputException;
import com.rest.calculate.shipping.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/calculate")
public class CalculateShippingController {

	@Autowired
	private AddressService addrService;

	@PostMapping(value = END_POINT_CALCULATE_SHIPPING, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> calculateShipping(@RequestBody Cep cep) throws Exception {
		try {
			Address address = addrService.getAddressByCep(cep.getCep());
			if (address.isErro()) {
				log.info(MSG_INFO_ZIP_CODE_NOT_FOUND);
				throw new InvalidInputException(MSG_INFO_ZIP_CODE_NOT_FOUND);
			}
			return new ResponseEntity<>(addrService.calculateShippingValueByAddress(address), HttpStatus.OK);
		} catch (InvalidInputException iie){
			log.error(MSG_ERROR_CALCULATING_SHIPPING, iie.getMessage(), iie);
			return new ResponseEntity<>(MSG_INFO_ZIP_CODE_NOT_FOUND, HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			log.error(MSG_ERROR_CALCULATING_SHIPPING, e.getMessage(), e);
			return new ResponseEntity<>(MSG_ERROR_CALCULATING_SHIPPING, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
