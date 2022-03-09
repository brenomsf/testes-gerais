package br.com.bmsf.testesjpa.view;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsf.testesjpa.data.entity.Distribuidor;
import br.com.bmsf.testesjpa.data.entity.DistribuidorExterno;
import br.com.bmsf.testesjpa.data.entity.DistribuidorInterno;
import br.com.bmsf.testesjpa.data.entity.Produtor;
import br.com.bmsf.testesjpa.data.repository.DistribuidorExternoRepository;
import br.com.bmsf.testesjpa.data.repository.DistribuidorInternoRepository;
import br.com.bmsf.testesjpa.data.repository.DistribuidorRepository;
import br.com.bmsf.testesjpa.data.repository.ProdutorRepository;

@RestController
@RequestMapping("/participante")
public class Controller {

	@Autowired
	private DistribuidorRepository distribuidorRepository;
	
	@Autowired
	private DistribuidorExternoRepository distribuidorExternoRepository;
	
	@Autowired
	private DistribuidorInternoRepository distribuidorInternoRepository;
	
	@Autowired
	private ProdutorRepository produtorRepository;
	
	@GetMapping("/distribuidor")
	public ResponseEntity<List<Distribuidor>> consultarDistribuidor(){
		List<Distribuidor> resultado = distribuidorRepository.findAll(); 
		
		return ResponseEntity.ok(resultado);
	}
	
	@GetMapping("/distribuidor/async/{id}")
	public ResponseEntity<List<Object>> consultarDistribuidorDetalhadoAsync(@PathVariable String id){
		CompletableFuture<Optional<DistribuidorInterno>> interno = 
					CompletableFuture.supplyAsync(()->distribuidorInternoRepository.findById(id));
		
		CompletableFuture<Optional<DistribuidorExterno>> externo = 
				CompletableFuture.supplyAsync(()->distribuidorExternoRepository.findById(id));
		
//		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(interno,externo);
		
		List<Object> lista = Stream.of(interno,externo)
			.map(CompletableFuture::join)
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/distribuidor/sync/{id}")
	public ResponseEntity<List<Object>> consultarDistribuidorDetalhadoSync(@PathVariable String id){
		Optional<DistribuidorInterno> interno = distribuidorInternoRepository.findById(id);
		Optional<DistribuidorExterno> externo = distribuidorExternoRepository.findById(id);
		
		return ResponseEntity.ok(Arrays.asList(interno,externo));
	}
	
	@GetMapping("/distribuidor/externo")
	public ResponseEntity<List<DistribuidorExterno>> consultarDistribuidorExterno(){
		List<DistribuidorExterno> resultado = distribuidorExternoRepository.findAll(); 
		
		return ResponseEntity.ok(resultado);
	}
	
	@GetMapping("/produtor")
	public ResponseEntity<List<Produtor>> consultarProdutor(){
		List<Produtor> resultado = produtorRepository.findAll(); 
		
		return ResponseEntity.ok(resultado);
	}
}
