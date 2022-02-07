package br.com.bmsf.praticakakfa.controller;

public class CidadeModel {

	private String nome;
	private Integer populacao;
	private String uf;
	
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
	 * @return the populacao
	 */
	public Integer getPopulacao() {
		return populacao;
	}
	/**
	 * @param populacao the populacao to set
	 */
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}
	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
