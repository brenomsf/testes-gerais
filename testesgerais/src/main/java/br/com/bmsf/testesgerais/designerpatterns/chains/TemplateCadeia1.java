package br.com.bmsf.testesgerais.designerpatterns.chains;

public abstract class TemplateCadeia1 {

	private TemplateCadeia1 proximo;
	
	public TemplateCadeia1 vincularProximo(TemplateCadeia1 proximo) {
		this.proximo = proximo;
		return proximo;
	}
	
	
	public void processar(String texto1, String texto2) {
		this.regra(texto1, texto2);
		
		if(this.proximo != null) {
			this.proximo.regra(texto1, texto2);
		}
	}
	
	protected abstract void regra(String texto1, String texto2);
}
