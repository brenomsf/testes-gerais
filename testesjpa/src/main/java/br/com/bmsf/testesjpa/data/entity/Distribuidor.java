package br.com.bmsf.testesjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Subselect;

@Entity
@Subselect(
		"select * from distribuidor_interno union all select * from distribuidor_externo"
)
public class Distribuidor {
	
	@Id
	private String id_participante;
	
	private String nome;
	
//	private String codigo_empresa;
	
//	private String codigo_pessoa;
}
