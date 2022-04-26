package br.com.bmsf.testesgerais.designerpatterns.chains;

public class ValidacaoA extends TemplateCadeia2{

	@Override
	protected void regra(Pojo pojo) {
		System.out.println("ValidacaoA >> "+pojo);
		pojo.setTexto("ValidacaoA");
		getPojoTesteTeste().setTexto("ValidacaoA");
	}
}
