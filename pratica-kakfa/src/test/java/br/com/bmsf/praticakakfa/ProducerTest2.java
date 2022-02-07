package br.com.bmsf.praticakakfa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import br.com.bmsf.praticakakfa.controller.CidadeModel;
import br.com.bmsf.praticakakfa.service.Producer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@EmbeddedKafka(partitions = 1, bootstrapServersProperty = "spring.kafka.bootstrap-servers")
@SpringBootTest
@SpringJUnitConfig
public class ProducerTest2 {

	@Spy
	private Producer producer;

	@MockBean
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private EmbeddedKafkaBroker embeddedKafkaBroker;

	BlockingQueue<ConsumerRecord<String, String>> records;

	KafkaMessageListenerContainer<String, String> container;

	@BeforeAll
	void setUp() {
		System.setProperty("spring.kafka.bootstrap-servers", embeddedKafkaBroker.getBrokersAsString());

		Map<String, Object> configs = new HashMap<>(
				KafkaTestUtils.consumerProps("consumer", "false", embeddedKafkaBroker));
		DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(configs,
				new StringDeserializer(), new StringDeserializer());
		ContainerProperties containerProperties = new ContainerProperties("cidade.criado");
		container = new KafkaMessageListenerContainer<>(consumerFactory, containerProperties);
		records = new LinkedBlockingQueue<>();
		container.setupMessageListener((MessageListener<String, String>) records::add);
		container.start();
		ContainerTestUtils.waitForAssignment(container, embeddedKafkaBroker.getPartitionsPerTopic());
	}

	@AfterAll
	void tearDown() {
		container.stop();
	}

	@Test
	public void teste1() throws InterruptedException {
//		Consumer<Integer, String> consumer = configureConsumer();
		
		CidadeModel model = new CidadeModel();
		model.setNome("Santo André");
		model.setPopulacao(1000000);
		model.setUf("SP");

		producer.enviar(model);
      
      ConsumerRecord<String, String> received = records.poll(10, TimeUnit.SECONDS);
      assertNotNull(received);
      

//		ConsumerRecord<Integer, String> singleRecord = KafkaTestUtils.getSingleRecord(consumer, "cidade.criado");
//
//		assertNotNull(singleRecord);
	}

//	private Consumer<Integer, String> configureConsumer() {
//		System.setProperty("spring.kafka.bootstrap-servers", embeddedKafkaBroker.getBrokersAsString());
//
//		Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("consumer_1", "true", embeddedKafkaBroker);
//
//		consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//		Consumer<Integer, String> consumer = new DefaultKafkaConsumerFactory<Integer, String>(consumerProps)
//				.createConsumer();
//
//		consumer.subscribe(Collections.singleton("cidade.criado"));
//
//		return consumer;
//	}
}
