package br.com.bmsf.testesjpa.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsf.testesjpa.data.entity.Distribuidor;
import br.com.bmsf.testesjpa.data.entity.DistribuidorExterno;
import br.com.bmsf.testesjpa.data.entity.Produtor;
import br.com.bmsf.testesjpa.data.repository.DistribuidorExternoRepository;
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
	private ProdutorRepository produtorRepository;
	
	@GetMapping("/distribuidor")
	public ResponseEntity<List<Distribuidor>> consultarDistribuidor(){
		List<Distribuidor> resultado = distribuidorRepository.findAll(); 
		
		return ResponseEntity.ok(resultado);
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
