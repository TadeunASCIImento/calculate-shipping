package com.rest.calculate.shipping.enums.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rest.calculate.shipping.enums.ShippingValueByRegionEnum;

class ShippingValueByRegionEnumTest {

	@Test
	void shouldReturnShippingValueByRegionFromParseMethodByRegion() {
		ShippingValueByRegionEnum region = ShippingValueByRegionEnum.parse("Sul");
		assertEquals(17.30, region.getShipping());
	}

}
