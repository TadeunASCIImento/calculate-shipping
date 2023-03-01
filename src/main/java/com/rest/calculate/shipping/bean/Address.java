package com.rest.calculate.shipping.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements Serializable{

	private static final long serialVersionUID = 152938413907408373L;

	    private String cep;
	    private String logradouro;
	    private String complemento;
	    private String bairro;
	    private String localidade;
	    private String uf;
	    private Long ibge;
	    private Long gia;
	    private Integer ddd;
	    private Long siafi;
	    private boolean erro;
}
