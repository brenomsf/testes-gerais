package br.com.bmsf.testesgerais.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaTemplate {
	
	@Autowired
	private ConfigProperties properties;
	
	@Bean
	public void enviarMensagem() {
		System.out.println("Mensagem Enviada " + properties.getNomeTopico());
	}

}
