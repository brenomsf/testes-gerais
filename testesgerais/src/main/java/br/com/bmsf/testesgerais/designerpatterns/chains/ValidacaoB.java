package br.com.bmsf.testesgerais.designerpatterns.chains;

public class ValidacaoB extends TemplateCadeia2{

	@Override
	protected void regra(Pojo pojo) {
		System.out.println("ValidacaoB >> "+pojo);
		pojo.setTexto("ValidacaoB");
		getPojoTesteTeste().setTexto("ValidacaoB");
	}
}
