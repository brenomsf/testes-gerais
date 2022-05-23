package br.com.bmsf.praticapatch.dataprovider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "animal")
public class AnimalEntity {

	@Id
	@Column(name = "id_animal")
	private Integer idAnimal;
	
	@Column(name = "nome_animal")
	private String nomeAnimal;
	
	@Column(name = "id_habitat")
	private String idHabitat;
	
	@Column(name = "codigo_especie")
	private String codigoEspecie;
	
	

	/**
	 * @return the idAnimal
	 */
	public Integer getIdAnimal() {
		return idAnimal;
	}

	/**
	 * @param idAnimal the idAnimal to set
	 */
	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	/**
	 * @return the nomeAnimal
	 */
	public String getNomeAnimal() {
		return nomeAnimal;
	}

	/**
	 * @param nomeAnimal the nomeAnimal to set
	 */
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	/**
	 * @return the idHabitat
	 */
	public String getIdHabitat() {
		return idHabitat;
	}

	/**
	 * @param idHabitat the idHabitat to set
	 */
	public void setIdHabitat(String idHabitat) {
		this.idHabitat = idHabitat;
	}

	/**
	 * @return the codigoEspecie
	 */
	public String getCodigoEspecie() {
		return codigoEspecie;
	}

	/**
	 * @param codigoEspecie the codigoEspecie to set
	 */
	public void setCodigoEspecie(String codigoEspecie) {
		this.codigoEspecie = codigoEspecie;
	}
	
}
