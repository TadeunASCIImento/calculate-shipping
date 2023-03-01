package com.rest.calculate.shipping.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingValueByRegionEnum {

	SUL("Sul", 17.30),
	NORTE("Norte", 20.83),
	SUDESTE("Sudeste", 7.85), 
	NORDESTE("Nordeste", 15.98), 
	CENTRO_OESTE("Centro-Oeste", 12.50);
	
	private String region;
	private Double shipping;
	
	public static ShippingValueByRegionEnum parse(final String region) {
		List<ShippingValueByRegionEnum> shippings = Arrays.asList(ShippingValueByRegionEnum.values());
		return shippings.stream()
				.filter(shipping -> region.equalsIgnoreCase(shipping.getRegion()))
				.collect(Collectors.toList()).get(0);
	
	}

}
