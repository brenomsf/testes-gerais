package br.com.bmsf.testesgerais.designerpatterns;

import java.util.Map;

public class Teste1 {
	private Map<String, String> headers;
	private String bearer;
	
	public Teste1 (String servico) {
		montarHeader(servico);
	}
	
	public Map<String, String> getHeaders(){
		return this.headers;
	}
	
	private void montarHeader(String servico) {
		headers.put("apiKey", "fafafafa");
		
		switch (servico) {
		case "a":
			headers.put("Authoration", getCredenciais(servico));
			break;

		default:
			break;
		}
	}
	
	private String getCredenciais(String servico) {
		switch (servico) {
		case "a":
			this.bearer = "";
			break;

		default:
			break;
		}
		return this.bearer;
	}

}
