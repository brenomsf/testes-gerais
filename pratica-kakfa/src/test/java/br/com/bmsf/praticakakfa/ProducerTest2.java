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
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.bmsf.praticakakfa.controller.CidadeModel;
import br.com.bmsf.praticakakfa.service.Producer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@EmbeddedKafka(partitions = 1, bootstrapServersProperty = "spring.kafka.bootstrap-servers")
@SpringBootTest
@SpringJUnitConfig
@ExtendWith(SpringExtension.class)
public class ProducerTest2 {

	@Spy
	private Producer producer;

//	@MockBean
//	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private EmbeddedKafkaBroker embeddedKafkaBroker;

	BlockingQueue<ConsumerRecord<String, String>> records;

	KafkaMessageListenerContainer<String, String> container;

	@BeforeAll
	void setUp() {
		
	    Map<String, Object> configProps = new HashMap<>();

	    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,embeddedKafkaBroker.getBrokersAsString());
	    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
	    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
	    ReflectionTestUtils.setField(producer, "kafkatempate", new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps)));
	    
	    
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
