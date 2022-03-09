package br.com.bmsf.testesjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Subselect(
		"select id_participante,nome,codigo_empresa,null as codigo_pessoa from produtor_interno "
		+ "union select id_participante,nome,null as codigo_empresa,codigo_pessoa from produtor_externo"		
)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Produtor {
	
	@Id
	private String id_participante;
	
	private String nome;

//	private String codigo_empresa;
//	
//	private String codigo_pessoa;
	
	/**
	 * @return the id_participante
	 */
	public String getId_participante() {
		return id_participante;
	}

	/**
	 * @param id_participante the id_participante to set
	 */
	public void setId_participante(String id_participante) {
		this.id_participante = id_participante;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
