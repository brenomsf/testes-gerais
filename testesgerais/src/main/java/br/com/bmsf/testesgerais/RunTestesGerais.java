package br.com.bmsf.testesgerais;

import br.com.bmsf.testesgerais.designerpatterns.chains.Pojo;
import br.com.bmsf.testesgerais.designerpatterns.chains.TemplateCadeia2;
import br.com.bmsf.testesgerais.designerpatterns.chains.TestarCadeia;
import br.com.bmsf.testesgerais.designerpatterns.chains.ValidacaoA;
import br.com.bmsf.testesgerais.designerpatterns.chains.ValidacaoB;
import br.com.bmsf.testesgerais.designerpatterns.chains.ValidacaoC;

//import br.com.bmsf.testesgerais.arquivos.GerarArquivos;

public class RunTestesGerais {

	public static void main(String[] args) {
//		GerarArquivos.texto();
		
		Pojo pojo = new Pojo();
		
		TestarCadeia testeCadeia = new TestarCadeia();
		
		testeCadeia.testar(pojo);
		
		System.out.println("pojo.getTexto >> "+pojo.getTexto()+" >> "+pojo);
		System.out.println("testeCadeia.getPojoTest.getTexto >> "+testeCadeia.getPojoTest().getTexto()+" >> "+testeCadeia.getPojoTest());
	}
}
