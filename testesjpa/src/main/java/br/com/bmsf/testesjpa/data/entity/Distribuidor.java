package br.com.bmsf.testesjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Subselect(
		"select id_participante,nome,codigo_empresa,null as codigo_pessoa from distribuidor_interno "
		+ "union select id_participante,nome,null as codigo_empresa,codigo_pessoa from distribuidor_externo"
)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Distribuidor {
	
	@Id
	private String id_participante;
	
	private String nome;
	
	private String codigo_empresa;
	
	private String codigo_pessoa;

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

	/**
	 * @return the codigo_empresa
	 */
	public String getCodigo_empresa() {
		return codigo_empresa;
	}

	/**
	 * @param codigo_empresa the codigo_empresa to set
	 */
	public void setCodigo_empresa(String codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}

	/**
	 * @return the codigo_pessoa
	 */
	public String getCodigo_pessoa() {
		return codigo_pessoa;
	}

	/**
	 * @param codigo_pessoa the codigo_pessoa to set
	 */
	public void setCodigo_pessoa(String codigo_pessoa) {
		this.codigo_pessoa = codigo_pessoa;
	}
}
