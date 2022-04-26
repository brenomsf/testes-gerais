package br.com.bmsf.testesgerais.designerpatterns.chains;

import java.util.Random;

public class Pojo {

	private String texto;
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "POJO [ "+ (new Random().nextInt((100 - 1) + 1) + 1)+" ]";
	}
}
