package com.rest.calculate.shipping.utils;

import org.springframework.stereotype.Component;

@Component
public class AddressServiceUtil {

	public String removeMaskFromCEP(String cep) {
		return cep.replaceAll("\\-", "");
	}
}
