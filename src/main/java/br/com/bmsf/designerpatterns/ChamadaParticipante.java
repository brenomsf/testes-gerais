package br.com.bmsf.designerpatterns;

import java.util.Map;

public class ChamadaParticipante extends MontarChamada{

	
	public ChamadaParticipante(String ambiente) {
		this.montarHeader(ambiente);
	}
	
	@Override
	protected void setAmbienteLocal(String chaveBearer) {
		Map<String, String> headers = this.getHeaders();
		
		headers.put("apiKey", "fafafafa");
		headers.put("apiKey", "fafafafa");
		headers.put("authorization", chaveBearer);
		
	}

	@Override
	protected void setAmbienteDev(String chaveBearer) {
		Map<String, String> headers = this.getHeaders();
		
		headers.put("apiKey", "fafafafa");
		headers.put("apiKey", "fafafafa");
		headers.put("authorization", chaveBearer);
		
	}
}
