package com.rest.calculate.shipping.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.dto.AddressDTO;

@Service
public class AddressService {

	private final String URL_BASE_API_VIA_CEP = "https://viacep.com.br/ws/";
	private final String RETURN_TYPE_JSON = "json";

	public RestTemplate template() {
		return new RestTemplate();
	}

	public AddressDTO getAddressByCep(String cep) {
		final String URL_API_VIA_CEP_GET_ADDRESS_BY_CEP = URL_BASE_API_VIA_CEP
				.concat("/" + cep + "/" + "/" + RETURN_TYPE_JSON);
		Address address = template().getForObject(URL_API_VIA_CEP_GET_ADDRESS_BY_CEP, Address.class);
		return new AddressDTO(address);
	}

}
