package com.rest.calculate.shipping.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateByRegionEnum {
	
	ACRE("AC","Norte"),
	PARA("PA","Norte"),
	AMAPA("AP","Norte"),
	RORAIMA("RR","Norte"),
	RONDONIA("RO","Norte"),
	AMAZONAS("AM","Norte"),
	TOCANTIS("TO",	"Norte"),
	PIAUI("PI", "Nordeste"),
	BAHIA("BA", "Nordeste"),
	PARAIBA("PB", "Nordeste"),
	SERGIPE("SE", "Nordeste"),
	CEARA	("CE", "Nordeste"),
	ALAGOAS	("AL", "Nordeste"),
	MARANHAO("MA", "Nordeste"),
	PERNAMBUCO	("PE", "Nordeste"),
	RIO_GRANDE_DO_NORTE("RN", "Nordeste"),
	GOIAS("GO", "Centro-Oeste"),
	MATO_GROSSO("MT", "Centro-Oeste"),
	DISTRITO_FEDERAL("DF", "Centro-Oeste"),
	MATO_GROSSO_DO_SUL("MS", "Centro-Oeste"),
	SAO_PAULO("SP", "Sudeste"),
	MINAS_GERAIS("MG", "Sudeste"),
	RIO_DE_JANEIRO("RJ", "Sudeste"),
	ESPIRITO_SANTO("ES", "Sudeste"),
	PAARANA("PR","Sul"),
	SANTA_CATARINA("SC","Sul"),
	RIO_GRANDE_DO_SUL(	"RS","Sul");

	private String uf;
	private String region;

	public static StateByRegionEnum parse(final String uf) {
		List<StateByRegionEnum> states = Arrays.asList(StateByRegionEnum.values());
		return states.stream()
				.filter(state -> uf.equalsIgnoreCase(state.getUf()))
				.collect(Collectors.toList()).get(0);
	}
	
}
