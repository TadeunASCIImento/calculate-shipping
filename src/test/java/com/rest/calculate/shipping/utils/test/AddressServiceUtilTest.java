package com.rest.calculate.shipping.utils.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rest.calculate.shipping.utils.AddressServiceUtil;

class AddressServiceUtilTest {

	@Test
	void shoudRemoveMaskFromCEP() {
		String cep = "000-00-000";
		AddressServiceUtil util = new AddressServiceUtil();
		String cepWithoutMask = util.removeMaskFromCEP(cep);
		assertTrue(!cepWithoutMask.contains("-"));
	}

}
