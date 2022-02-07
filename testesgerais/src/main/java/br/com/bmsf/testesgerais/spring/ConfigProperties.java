package br.com.bmsf.testesgerais.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@PropertySource("classpath:application.properties")
public class ConfigProperties {
	
	
	private String nomeTopico;
	private String endpoint;
	private String user; 
	private String pws;
	private String tipoMsg;
	
	
	/**
	 * @return the nomeTopico
	 */
	public String getNomeTopico() {
		return nomeTopico;
	}
	/**
	 * @param nomeTopico the nomeTopico to set
	 */
	public void setNomeTopico(String nomeTopico) {
		this.nomeTopico = nomeTopico;
	}
	/**
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}
	/**
	 * @param endpoint the endpoint to set
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the pws
	 */
	public String getPws() {
		return pws;
	}
	/**
	 * @param pws the pws to set
	 */
	public void setPws(String pws) {
		this.pws = pws;
	}
	/**
	 * @return the tipoMsg
	 */
	public String getTipoMsg() {
		return tipoMsg;
	}
	/**
	 * @param tipoMsg the tipoMsg to set
	 */
	public void setTipoMsg(String tipoMsg) {
		this.tipoMsg = tipoMsg;
	}
	
	

}
