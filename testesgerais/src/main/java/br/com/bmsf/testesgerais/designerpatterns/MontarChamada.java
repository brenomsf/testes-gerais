package br.com.bmsf.testesgerais.designerpatterns;

import java.util.Map;

public abstract class MontarChamada {

	private Map<String, String> headers;
	private String bearer;
	private String url;
	private String body;
	
	public Map<String, String> getHeaders(){return this.headers;}
	
	public String getBearer(){return this.bearer;}
	
	protected void montarHeader(String ambiente) {
		switch (ambiente) {
		case "local":
			setAmbienteLocal(gerarCredenciais(ambiente));
			break;
		case "dev":
			setAmbienteDev(gerarCredenciais(ambiente));
			break;
		}
	}
	
	private String gerarCredenciais(String ambiente) {
		url = ambiente;
		body = ambiente;
		
		return "Bearer" + gerarChaveBearer();
	}
	
	private String gerarChaveBearer() {
		String sts = this.url + this.body;
		
		return sts;
	}
	
	protected abstract void setAmbienteLocal(String chaveBearer);
	protected abstract void setAmbienteDev(String chaveBearer);
}
