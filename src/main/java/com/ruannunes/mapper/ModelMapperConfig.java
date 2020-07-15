package com.ruannunes.mapper;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author ruan nunes
 * @date 12/07/2020
 * @description Configuração de Bean, basicamente utilizo uma biblioteca para fazer o mapper automatico da entity e Dto
 * 				essa lib me permite fazer o bynd entre os atributos de maneira STRICT LOOSE STANDARD, cada uma dela faz
 * 				uma porcentagem de parecer entre atributos para fazer o bind.
 */

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		//Seta configuração de mapper para ser restrito a nomes  exatos e não semelhantes
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());

		return modelMapper;
	}
}
