package br.com.bmsf.demoresp.dataprovider;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Questoes")
public class QuestoesDoc2 {
	
	  @Id
	  private String id;
	  
	  @Field(name = "id_questao")
	  private String idQuestao;
	  
	  @Field(name = "valor_resposta")
	  private String valorResposta;
	  
	  @Field(name = "intevalo_minimo")
	  private Double intevaloMinimo;
	  
	  @Field(name = "intevalo_maximo")
	  private Double intevaloMaximo;
	  
	  @Field(name = "valores_aceitos")
	  private String valoresAceitos;
	  
	  @Field(name = "valores_nao_aceitos")
	  private String valoresNaoAceitos;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the idQuestao
	 */
	public String getIdQuestao() {
		return idQuestao;
	}

	/**
	 * @return the valorQuestao
	 */
	public String getValorResposta() {
		return valorResposta;
	}

	/**
	 * @return the intevaloMinimo
	 */
	public Double getIntevaloMinimo() {
		return intevaloMinimo;
	}

	/**
	 * @return the intevaloMaximo
	 */
	public Double getIntevaloMaximo() {
		return intevaloMaximo;
	}

	/**
	 * @return the valoresAceitos
	 */
	public String getValoresAceitos() {
		return valoresAceitos;
	}

	/**
	 * @return the valoresNaoAceitos
	 */
	public String getValoresNaoAceitos() {
		return valoresNaoAceitos;
	}
	    
}
