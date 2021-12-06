package br.com.bmsf.testesgerais.test;

import javax.validation.constraints.AssertTrue;

import org.springframework.http.HttpStatus;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ValidatableResponse;

import br.com.bmsf.testesgerais.designerpatterns.ChamadaParticipante;
import br.com.bmsf.testesgerais.designerpatterns.MontarChamada;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarParticipantesTestSteps {

	private final MontarChamada chamadaParticipante = new ChamadaParticipante("HOMOLOGACAO");
	private final MontarChamada chamadaEQ3 = new ChamadaParticipante("HOMOLOGACAO");
	
	
	private JsonPath pathBody;
	private ValidatableResponse validatableResponse;
	private String urlApp;
	private String urlEq3;
	private Object payload;
	private String numeroDocumento;
	private String tipoParticipante;
	private String participanteCadastrado;
	private String statusDadosCadastro;
	private int statusEsperadoApp;
	private int statusEsperadoEQ3;
	private int statusEQ3;	
	
	
	@Dado("que estou na plataforma de seguros para a criação de um participante \"([^\"]*)\"$")
	public void queEstouNaPlataformaDeSegurosParaACriacaoDeUmParticipante(String pessoaExiste) {
		this.statusEQ3 = "SIM".equalsIgnoreCase(pessoaExiste) ? HttpStatus.OK.value() : HttpStatus.NO_CONTENT.value();
		
		this.urlApp = new StringBuilder()
				.append("url chamada")
				.toString();
		
	}
	

	@Quando("informo os dados de cadastro \"([^\"]*)\"$ de um participante \"([^\"]*)\"$ do tipo pessoa jurídica \"([^\"]*)\"$")
	public void informoOsDadosDeCadastroDeUmParticipanteDoTipoPessoa(String statusDadosCadastro, String participanteCadastrado, String tipoParticipante) {
//		this.payload = "JURIDICA".equalsIgnoreCase(tipoParticipante) ? new Object() : new Object();
//																	    juridica		fisica
		boolean isCnpjValido;
		String rotaEq3 = "url chamada com parametro";		
		this.statusDadosCadastro = statusDadosCadastro;
		this.tipoParticipante = tipoParticipante;
		this.participanteCadastrado = participanteCadastrado;
		
		if("JURIDICA".equalsIgnoreCase(tipoParticipante)) {
			do {
				this.numeroDocumento = "41576265845";
				
				this.urlEq3 = new StringBuilder()
						.append(rotaEq3)
						.append(numeroDocumento)
						.toString();
				
				ValidatableResponse responseEQ3 = RestAssured.get(urlEq3).then();
				
				isCnpjValido = responseEQ3.extract().statusCode() == statusEQ3;
			} while(isCnpjValido);
		}
		
		
		this.payload = gerarParticipante();
		
		this.validatableResponse = RestAssured.post(urlApp).then();
		
		this.pathBody = new JsonPath(validatableResponse.extract().body().asString());
	}	
	
	@Entao("ao realizar o cadastro na plataforma receberei um status \"([^\"]*)\"$")
	public void aoRealizarOCadastroNaPlataformaRecebereiUmStatus(int statusEsperadoApp) {
		this.statusEsperadoApp = statusEsperadoApp;
		
		//assertTrue(validatableResponse.extract().statusCode() == this.statusEsperadoApp);
		
		if(statusEsperadoApp == 200) {			
			Object response = this.pathBody.getObject("data", Object.class);	
			//assertAll(()-> assertNull());
		}
	}
	
	@E("devera ser realizado um novo cadastrado no sistema corporativo de pessoas do banco \"([^\"]*)\"$")
	public void deveraSerRealizadoUmNovoCadastradoNoSistemaCorporativoDePessoasDoBanco(int statusEsperadoEQ3) {
		this.statusEsperadoEQ3 = statusEsperadoEQ3;
		this.validatableResponse = RestAssured.get(urlEq3).then();
		
		//assertTrue(validatableResponse.extract().statusCode() == this.statusEsperadoEQ3);
	}
	
	
	@E("devera ser exibida uma mensagem de falha no cadastro do participante \"([^\"]*)\"$")
	public void deveraSerExibidaUmaMensagemDeFalhaNoCadastroDoParticipante(String mensagem) {

		//assertAll(()-> assertEquals(mensagem, this.pathBody.getString("data.mensagem")));
	}
	
	private Object gerarParticipante () {
		switch (tipoParticipante) {
		case "JURIDICO":
			if("SIM".equalsIgnoreCase(this.participanteCadastrado)) {
				return new Object();
//				  participante ja cadastrado				
			}else if(this.statusEsperadoApp != 200){
				if("INCOMPLETO".equalsIgnoreCase(this.statusDadosCadastro)) {
					return new Object();
//				       participante incompleto						
				}else {
					return new Object();
//				       participante invalido						
				}
			}else {
				return new Object();
//				     participante novo					
			}	
		case "FISICA":
			return new Object();
		default:
			return null;
		}
	}
}
