package br.com.bmsf.demoresp.dataprovider;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends MongoRepository<QuestoesDoc2, String>{
	
	QuestoesDoc2 findByIdQuestao(String id);

}
