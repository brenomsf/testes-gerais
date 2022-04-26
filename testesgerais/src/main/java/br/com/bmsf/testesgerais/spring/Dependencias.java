package br.com.bmsf.testesgerais.spring;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Dependencias {

	private KafkaTemplate template;
	
	public static KafkaTemplate getKafkaTemplate( KafkaTemplate template) {
		return template;
	}
}
