package br.com.bmsf.testesgerais.designerpatterns.chains;

public abstract class TemplateCadeia2{

	private TemplateCadeia2 proximo;
	private Pojo pojoTesteTeste;
	
	public TemplateCadeia2() {
		this.pojoTesteTeste = new Pojo();
	}
	
	public TemplateCadeia2 vincularProximo(TemplateCadeia2 proximo) {
		this.proximo = proximo;
		return proximo;
	}
	
	
	public void processar(Pojo pojo) {
		this.regra(pojo);
		
		if(this.proximo != null) {
			this.proximo.processar(pojo);
		}
	}
	
	protected abstract void regra(Pojo pojo);


	public Pojo getPojoTesteTeste() {
		return pojoTesteTeste;
	}

	public void setPojoTesteTeste(Pojo pojoTesteTeste) {
		this.pojoTesteTeste = pojoTesteTeste;
	}
	
}
