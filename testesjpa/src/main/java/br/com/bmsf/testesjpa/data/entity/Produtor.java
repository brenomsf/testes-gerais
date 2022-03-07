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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Subselect(
		"select * from produtor_interno union all select * from produtor_externo"
)
public class Produtor {
	
	@Id
	private String id_participante;
	
	private String nome;
	
//	private String codigo_empresa;
	
//	private String codigo_pessoa;
}
