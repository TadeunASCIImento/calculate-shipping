package com.rest.calculate.shipping.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.bean.Cep;
import com.rest.calculate.shipping.controllers.CalculateShippingController;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateShippingControllerTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	protected CalculateShippingController controller;

	@Test
	void shouldCalculateShipping() throws Exception {
		Cep cep = new Cep();
		cep.setCep(getOneAddress().getCep());
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("/calculate/shipping")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(cep));
		
		MvcResult mvcResult = (MvcResult) mockMvc.perform(request).andReturn();
		
		assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());

	}

	private Address getOneAddress() {
		Address address = new Address();
		address.setCep("84570970");
		address.setLogradouro("Avenida Vicente Machado");
		address.setComplemento("casa");
		address.setBairro("Centro");
		address.setLocalidade("Mallet");
		address.setUf("PR");
		address.setIbge(9999L);
		address.setGia(9999L);
		address.setDdd(42);
		address.setSiafi(9999L);
		address.setErro(false);
		return address;
	}

}
