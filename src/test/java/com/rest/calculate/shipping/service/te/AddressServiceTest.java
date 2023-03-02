package com.rest.calculate.shipping.service.te;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.service.AddressService;

@SpringBootTest
@AutoConfigureMockMvc
class AddressServiceTest {

	@Autowired
	private AddressService service;
	
	@Autowired 
	private Address address;

	
	@Test
	void shouldGetAddressByCep() throws Exception {
		address = service.getAddressByCep("06454-000");
		assertNotNull(address.getCep());
		
		boolean responseError = address.isErro();
		assertFalse(responseError);
		
	}

}
