package com.rest.calculate.shipping.impl.calculator;

import org.springframework.stereotype.Component;

import com.rest.calculate.shipping.bean.Address;
import com.rest.calculate.shipping.enums.ShippingValueByRegionEnum;
import com.rest.calculate.shipping.enums.StateByRegionEnum;
import com.rest.calculate.shipping.interfaces.CalculateShippingInterface;

@Component
public class CalculateShippingImpl implements CalculateShippingInterface {

	@Override
	public Double calculateShippingByAddress(Address address) {
		StateByRegionEnum state = StateByRegionEnum.parse(address.getUf());
		return ShippingValueByRegionEnum.parse(state.getRegion()).getShipping();
	}

}
