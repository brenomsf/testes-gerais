package br.com.bmsf.praticakakfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsf.praticakakfa.service.Producer;
import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private Tracer tracer;
	
	@PostMapping
	public CidadeModel cadastrarCidade(@RequestBody CidadeModel model) {
		Span span = tracer.buildSpan("Controler[rota = POST /cidades]").start();
		
		producer.enviar(model);
		
		System.out.println("THREAD CONTROLER: "+Thread.currentThread().getName());
		
		span.setTag("controler", true);
		span.finish();
		
		return null;
	} 

}
