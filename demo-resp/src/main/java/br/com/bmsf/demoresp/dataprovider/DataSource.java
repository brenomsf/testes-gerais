package br.com.bmsf.demoresp.dataprovider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class DataSource {

//	@Bean
//	public static DBCollection getCollectionDB() throws UnknownHostException {
//		return new MongoClient("localhost", 27017)
//				.getDB("local")
//				.getCollection("Questoes");
//	
//	}

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	}

	@Bean
	public MongoClientFactoryBean mongo() {
		MongoClientFactoryBean mongo = new MongoClientFactoryBean();
		mongo.setHost("localhost");
		return mongo;
	}

	@Bean
	public MongoDatabaseFactory mongoDatabaseFactory() {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(), "local");
	}
}
