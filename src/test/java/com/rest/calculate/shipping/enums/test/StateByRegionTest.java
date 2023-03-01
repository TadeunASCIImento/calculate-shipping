package com.rest.calculate.shipping.enums.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rest.calculate.shipping.enums.StateByRegionEnum;

class StateByRegionTest {

	@Test
	void shouldReturnStateRegionFromParseMethodByUf() {
		StateByRegionEnum state = StateByRegionEnum.parse("SP");
		assertTrue("Sudeste".equalsIgnoreCase(state.getRegion()));
	}
}
