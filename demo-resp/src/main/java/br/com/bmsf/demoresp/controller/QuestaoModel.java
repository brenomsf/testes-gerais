package br.com.bmsf.demoresp.controller;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonComponent
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class QuestaoModel{

	private String idQuestao;
	private String valorResposta;
	
	
	
	/**
	 * @return the idQuestao
	 */
	public String getIdQuestao() {
		return idQuestao;
	}
	/**
	 * @param idQuestao the idQuestao to set
	 */
	public void setIdQuestao(String idQuestao) {
		this.idQuestao = idQuestao;
	}
	/**
	 * @return the valorResposta
	 */
	public String getValorResposta() {
		return valorResposta;
	}
	/**
	 * @param valorResposta the valorResposta to set
	 */
	public void setValorResposta(String valorResposta) {
		this.valorResposta = valorResposta;
	}
}
