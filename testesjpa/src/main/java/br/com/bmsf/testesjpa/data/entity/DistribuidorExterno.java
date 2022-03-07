package br.com.bmsf.testesjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distribuidor_externo")
public class DistribuidorExterno {
	
	@Id
	private String id_participante;
	
	private String nome;
	
	private String codigo_pessoa;
}
