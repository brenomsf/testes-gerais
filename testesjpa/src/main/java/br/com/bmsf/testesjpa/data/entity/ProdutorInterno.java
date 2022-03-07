package br.com.bmsf.testesjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtor_interno")
public class ProdutorInterno extends Produtor{

//	@Id
//	private String id_participante;
//	
//	private String nome;
	
	private String codigo_empresa;
}
