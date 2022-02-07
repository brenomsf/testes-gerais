package br.com.bmsf.testesgerais.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Injecao {
	
	private KafkaTemplate template;
	
	public Injecao(KafkaTemplate template) {
		this.template = template;
	}
	
	public void processarMensagem() {
		enviarMensagem();
	}
	
	protected KafkaTemplate getTemplate() {
		return template;
	}
	
	abstract protected void enviarMensagem();

}
