package br.com.bmsf.testesjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distribuidor_interno")
public class DistribuidorInterno {

	@Id
	private String id_participante;
	
	private String nome;
	
	private String codigo_empresa;
}
