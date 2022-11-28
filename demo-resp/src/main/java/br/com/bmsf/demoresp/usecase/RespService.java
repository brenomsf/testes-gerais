package br.com.bmsf.demoresp.usecase;

import static java.util.List.of;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bmsf.demoresp.controller.QuestaoModel;
import br.com.bmsf.demoresp.dataprovider.QuestaoDocIntervalo;
import br.com.bmsf.demoresp.dataprovider.QuestaoDocSimples;
import br.com.bmsf.demoresp.dataprovider.QuestaoRepository;
import br.com.bmsf.demoresp.dataprovider.QuestoesDoc;
import br.com.bmsf.demoresp.dataprovider.QuestoesDoc2;

@Service
public class RespService {

	@Autowired
	private QuestaoRepository repository;
	
	public String consultarQuestoes(QuestaoModel questaoModel) {	
		QuestoesDoc2 questaoConsultada = repository.findByIdQuestao(questaoModel.getIdQuestao());
		
		return verificarRespostaQuestaoV1(questaoModel, questaoConsultada);
		
//		return verificarRespostaQuestaoV2(questaoModel, questaoConsultada);
	}
	
	// Tentativa um de código  >>>>>>>>>>>>>>>>>
	private String verificarRespostaQuestaoV1(QuestaoModel questaoModel, QuestoesDoc2 questaoConsultada){
		StringBuilder resultado = new StringBuilder();
		TiposQuestoesEnum tipoQuestao = verificarCamposExistentes(questaoConsultada);
		
		
		switch (tipoQuestao) {
		case SIMPLES:
			resultado.append(
					String.format(
							"O valor %s com a resposta", 
							questaoConsultada.getValorResposta().equalsIgnoreCase(questaoModel.getValorResposta())?"bate":"não bate"
					)
			);
			break;
		case INTERVALO:
			break;
		default:
			break;
		}
		
		
		return resultado.toString();
	}
	
	private TiposQuestoesEnum verificarCamposExistentes(QuestoesDoc2 questaoConsultada){
		List<String> camposValidos = new ArrayList<>();
		Class<? extends QuestoesDoc2> classeQuestoes = questaoConsultada.getClass();
		
		try {
			for(Method metodo:classeQuestoes.getDeclaredMethods()) {
				if(Objects.nonNull(metodo.invoke(questaoConsultada, (Object[])null)))camposValidos.add(metodo.getName());
			}
		}catch(Exception exce) {
			//LANÇA EXECAO QUANDO CAMPO NAO EXISTE
		}

		return verificarTipoQuestao(camposValidos);
		
	}
	
	private TiposQuestoesEnum verificarTipoQuestao(List<String> campos){
		if(campos.contains("getValorResposta")) return TiposQuestoesEnum.SIMPLES;
		if(campos.containsAll(of("getIntervaloMinimo","getIntervaloMaximo"))) return TiposQuestoesEnum.INTERVALO;
		
		return TiposQuestoesEnum.SIMPLES;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	// Tentativa dois de código  >>>>>>>>>>>>>>>>>
	private String verificarRespostaQuestaoV2(QuestaoModel questaoModel, QuestoesDoc questaoConsultada){
		StringBuilder resultado = new StringBuilder();
		
		if(questaoConsultada instanceof QuestaoDocSimples) {
			String.format(
					"O valor %s com a resposta", 
					((QuestaoDocSimples)questaoConsultada).getValorResposta().equalsIgnoreCase(questaoModel.getValorResposta())?"bate":"não bate"
			);
		}
		if(questaoConsultada instanceof QuestaoDocIntervalo) {
			
		};
		
		return resultado.toString();
	}
}
