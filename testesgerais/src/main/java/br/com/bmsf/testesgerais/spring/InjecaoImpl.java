package br.com.bmsf.testesgerais.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjecaoImpl extends Injecao {
		
	
	@Autowired
	public InjecaoImpl(KafkaTemplate template) {
		super(template);
	}
	
	@Override
	protected void enviarMensagem() {
		getTemplate().enviarMensagem();
	}

}
