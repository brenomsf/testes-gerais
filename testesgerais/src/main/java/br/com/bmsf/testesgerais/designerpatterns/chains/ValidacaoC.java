package br.com.bmsf.testesgerais.designerpatterns.chains;

public class ValidacaoC extends TemplateCadeia2{

	@Override
	protected void regra(Pojo pojo) {
		System.out.println("ValidacaoC >> "+pojo);
		pojo.setTexto("ValidacaoC");
		getPojoTesteTeste().setTexto("ValidacaoC");
	}
}
