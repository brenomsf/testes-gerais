package br.com.bmsf.testesgerais.designerpatterns.chains;

public class TestarCadeia {
	
	private Pojo pojoTest;
	
	public TestarCadeia() {
		this.pojoTest = new Pojo();
	}
	
	public void testar(Pojo pojo) {
		System.out.println("TestarCadeia >> "+pojo);
		TemplateCadeia2 cadeia = new ValidacaoA();
		
		ValidacaoB valB = new ValidacaoB();
		ValidacaoC valC = new ValidacaoC();
		
		cadeia
			.vincularProximo(valB)
			.vincularProximo(valC);
		
		this.pojoTest = pojo;
		
		cadeia.processar(pojo);
		
		System.out.println("cadeia.getPojoTesteTeste >> "+cadeia.getPojoTesteTeste().getTexto()+" >> "+cadeia.getPojoTesteTeste());
		System.out.println("cadeia.getPojoTesteTeste >> "+valB.getPojoTesteTeste().getTexto()+" >> "+valB.getPojoTesteTeste());
		System.out.println("cadeia.getPojoTesteTeste >> "+valC.getPojoTesteTeste().getTexto()+" >> "+valC.getPojoTesteTeste());
	}


	public Pojo getPojoTest() {
		return pojoTest;
	}

	public void setPojoTest(Pojo pojoTest) {
		this.pojoTest = pojoTest;
	}
}
