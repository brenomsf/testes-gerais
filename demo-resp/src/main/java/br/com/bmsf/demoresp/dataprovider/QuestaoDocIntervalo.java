package br.com.bmsf.demoresp.dataprovider;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Questoes")
public class QuestaoDocIntervalo extends QuestoesDoc{
	
	  @Field(name = "intevalo_minimo")
	  private Double intevaloMinimo;
	  
	  @Field(name = "intevalo_maximo")
	  private Double intevaloMaximo;
	
	
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
}
