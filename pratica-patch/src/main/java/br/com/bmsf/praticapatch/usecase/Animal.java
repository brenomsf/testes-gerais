package br.com.bmsf.praticapatch.usecase;

import java.util.Map;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonComponent
@JsonInclude(content = Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Animal {
	
	private Integer id;
	private String nome;
	private Map<String, String> habitat;
	private String codigoEspecie;
	
	
	public Animal() {}
	
	public Animal(Integer id,String nome,Map<String, String> habitat) {
		this.id = id;
		this.nome = nome;
		this.habitat = habitat;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the habitat
	 */
	public Map<String, String> getHabitat() {
		return habitat;
	}

	/**
	 * @return the codigoEspecie
	 */
	public String getCodigoEspecie() {
		return codigoEspecie;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param habitat the habitat to set
	 */
	public void setHabitat(Map<String, String> habitat) {
		this.habitat = habitat;
	}

	/**
	 * @param codigoEspecie the codigoEspecie to set
	 */
	public void setCodigoEspecie(String codigoEspecie) {
		this.codigoEspecie = codigoEspecie;
	}
	
}
