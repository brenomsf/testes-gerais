package br.com.bmsf.praticapatch.usecase;

import java.util.Collections;

import javax.persistence.EntityNotFoundException;
import javax.persistence.MapsId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bmsf.praticapatch.dataprovider.AnimalEntity;
import br.com.bmsf.praticapatch.dataprovider.AnimalRepository;

@Service
public class UseCase {

	@Autowired
	private AnimalRepository repository;
	
	private static Integer idAnimal = 0;
	
	public Animal cadastrar(Animal animal) {
		
		AnimalEntity entityNova = convertTo(animal);
		
		AnimalEntity entitySalva = repository.save(entityNova);
		
		return convertFrom(entitySalva);
	}
	
	public Animal consultar(Integer idAnimal) {
			
		AnimalEntity entitySalva = repository.findById(idAnimal).get();
		
		return convertFrom(entitySalva);
	}
	
	public Animal atualizar(Animal animal) {
		
		AnimalEntity animalSalvo = repository
				.findById(animal.getId())
				.orElseThrow(()->new EntityNotFoundException());
		
		AnimalEntity entityNova = assemble(animal, animalSalvo);
		
		AnimalEntity entitySalva = repository.save(entityNova);
		
		return convertFrom(entitySalva);
	}
	
	private AnimalEntity assemble(Animal animal, AnimalEntity animalEntity) {
		
		animalEntity.setIdAnimal(animal.getId());
		animalEntity.setNomeAnimal(animal.getNome());
		animalEntity.setIdHabitat(animal.getHabitat().get("id_habitat"));
		animalEntity.setCodigoEspecie(animal.getCodigoEspecie());
		
		return animalEntity;
	}
	
	private AnimalEntity convertTo(Animal animal) {
		AnimalEntity entity = new AnimalEntity();
		
		entity.setIdAnimal(generateId(++idAnimal, 1000));
		entity.setNomeAnimal(animal.getNome());
		entity.setIdHabitat(animal.getHabitat().get("id_habitat"));
		entity.setCodigoEspecie(animal.getCodigoEspecie());
		
		return entity;
	}
	
	private Animal convertFrom(AnimalEntity animalEntity) {
		Animal animal = new Animal();
		
		animal.setId(animalEntity.getIdAnimal());
		animal.setNome(animalEntity.getNomeAnimal());
		animal.setHabitat(Collections.singletonMap("id_habitat", animalEntity.getIdHabitat()));
		animal.setCodigoEspecie(animalEntity.getCodigoEspecie());
		
		return animal;
	}
	
	
	
	private Integer generateId(Integer minino, Integer maximo) {
		return minino + (int)(Math.random() * maximo);
	}
}
