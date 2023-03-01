package com.rest.calculate.shipping.impl.calculator.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.impl.calculator.CalculateShippingImpl;

class CalculateShippingImpTest {

	@Test
	void shouldCalculateShippingByAddress() {
		Address addressRegionSul = this.getOneAddress();
		CalculateShippingImpl calculateShippingImpl = new CalculateShippingImpl();
		Double shippingValueRegion = calculateShippingImpl.calculateShippingByAddress(addressRegionSul);
		assertTrue(shippingValueRegion.equals(shippingValueRegion));
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
