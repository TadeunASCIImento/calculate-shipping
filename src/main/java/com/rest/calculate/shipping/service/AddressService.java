package com.rest.calculate.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.dto.AddressDTO;
import com.rest.calculate.shipping.interfaces.CalculateShippingInterface;
import com.rest.calculate.shipping.utils.AddressServiceUtil;

@Service
public class AddressService {

	@Autowired
	private CalculateShippingInterface calculate;

	@Autowired
	private AddressServiceUtil util;

	private final String URL_BASE_API_VIA_CEP = "https://viacep.com.br/ws/";
	private final String RETURN_TYPE_JSON = "json";

	public RestTemplate template() {
		return new RestTemplate();
	}

	public Address getAddressByCep(String cep) throws Exception {
		final String URL_API_VIA_CEP_GET_ADDRESS_BY_CEP = URL_BASE_API_VIA_CEP
				.concat("/" + util.removeMaskFromCEP(cep) + "/" + "/" + RETURN_TYPE_JSON);
		try {
			return template().getForObject(URL_API_VIA_CEP_GET_ADDRESS_BY_CEP, Address.class);
		} catch (Exception e) {
			return null;
		}
	}

	public AddressDTO calculateShippingValueByAddress(Address address) {
		AddressDTO dto = new AddressDTO(address);
		dto.setFrete(calculate.calculateShippingByAddress(address));
		return dto;
	}

}
