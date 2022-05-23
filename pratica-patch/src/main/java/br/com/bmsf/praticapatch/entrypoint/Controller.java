package br.com.bmsf.praticapatch.entrypoint;


import javax.json.JsonPatch;
import javax.json.JsonStructure;
import javax.json.JsonValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bmsf.praticapatch.usecase.Animal;
import br.com.bmsf.praticapatch.usecase.UseCase;


@RestController
@RequestMapping("/animais")
public class Controller {

	
	@Autowired
	private UseCase usecase;
	
	@PostMapping
	public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal) {
		Animal response = usecase.cadastrar(animal);	
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping(path="/{id_animal}",consumes = "application/json-patch+json")
	public ResponseEntity<Animal> cadastrar(
			@PathVariable(name = "id_animal") Integer idAnimal,
			@RequestBody JsonPatch patchDocument
	) {
		JsonStructure  target = new ObjectMapper()
				.convertValue(usecase.consultar(idAnimal), JsonStructure.class);
		
		JsonValue patchAnimal = patchDocument.apply(target);
		
		Animal novoAnimal = new ObjectMapper().convertValue(patchAnimal, Animal.class);
		
		Animal response = usecase.cadastrar(novoAnimal);
		
		return ResponseEntity.ok(response);
	}
}
