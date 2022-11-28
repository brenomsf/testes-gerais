package br.com.bmsf.demoresp.dataprovider;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Questoes")
public class QuestaoDocSimples extends QuestoesDoc{

	  @Field(name = "valor_resposta")
	  private String valorResposta;

	  
		/**
		 * @return the valorQuestao
		 */
		public String getValorResposta() {
			return valorResposta;
		}
}
