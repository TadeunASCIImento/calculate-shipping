package com.rest.calculate.shipping.dto;

import java.io.Serializable;

import com.rest.calculate.shipping.bean.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO implements Serializable{

	private static final long serialVersionUID = -7528000448592385128L;
	
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
	private Double frete;
	
	public AddressDTO(Address address) {
		this.cep = address.getCep();
		this.rua = address.getLogradouro();
		this.complemento = address.getComplemento();
		this.bairro = address.getBairro();
		this.cidade = address.getLocalidade();
		this.estado = address.getUf();
	}

}
