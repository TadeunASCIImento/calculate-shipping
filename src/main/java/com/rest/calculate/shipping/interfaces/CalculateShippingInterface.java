package com.rest.calculate.shipping.interfaces;

import com.rest.calculate.shipping.bean.Address;

public interface CalculateShippingInterface {

	public Double calculateShippingByAddress(Address address);
}
