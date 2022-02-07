package br.com.bmsf.praticakakfa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bmsf.praticakakfa.controller.CidadeModel;
import io.opentracing.Span;
import io.opentracing.Tracer;

@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkatempate;
	
	@Autowired
	private Tracer tracer;
	
	@Async
	public Boolean enviar (CidadeModel mensage) {
		try {			
			Span span = tracer.buildSpan("Enviando mensagem ao topico").start();
			
			Message<String> msg = MessageBuilder
					.withPayload(new ObjectMapper().writeValueAsString(mensage))
					.setHeader(KafkaHeaders.TOPIC, "cidade.criado")
					.build();
			
			kafkatempate.send(msg);
			
			System.out.println("THREAD ENVIAR: "+Thread.currentThread().getName());
			
			span.setTag("producer", true);
			span.finish();
			
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
