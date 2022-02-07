package br.com.bmsf.praticakakfa;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bmsf.praticakakfa.controller.CidadeModel;
import br.com.bmsf.praticakakfa.service.Producer;

@SpringBootTest(classes = PraticaKakfaApplication.class)
@RunWith(SpringRunner.class)
@EmbeddedKafka(partitions = 1, topics = { "cidade.criado" })
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableRuleMigrationSupport
public class ProducerTest {

	@SpyBean
	private Producer producer;
	
	@Autowired
	private EmbeddedKafkaBroker mockBroker;
	
//	@ClassRule
//	public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, true, "cidade.criado");
	
	@MockBean
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
//    private KafkaMessageListenerContainer<String, String> container;
//    private BlockingQueue<ConsumerRecord<String, String>> consumerRecords;
//    private DefaultKafkaConsumerFactory<String, String> consumer;
    
    private KafkaMessageListenerContainer<String, String> container;
    private BlockingQueue<ConsumerRecord<String, String>> records;

    @BeforeEach
    public void setUp() {
      System.setProperty("spring.kafka.bootstrap-servers", mockBroker.getBrokersAsString());
    	
//        consumerRecords = new LinkedBlockingQueue<>();
//
//        ContainerProperties containerProperties = new ContainerProperties("cidade.criado");
//
//        Map<String, Object> consumerProperties = KafkaTestUtils.consumerProps(
//                "cosumcer_1", "false", mockBroker);
//
//        consumer = new DefaultKafkaConsumerFactory<>(consumerProperties);
//
//        container = new KafkaMessageListenerContainer<>(consumer, containerProperties);
//        
//        container.setupMessageListener((MessageListener<String, String>) record -> {
//            consumerRecords.add(record);
//        });
//        
//        container.start();
//
//        ContainerTestUtils.waitForAssignment(container, mockBroker.getPartitionsPerTopic());
    	
        // set up the Kafka consumer properties
        Map<String, Object> consumerProperties = KafkaTestUtils.consumerProps("consumer_1", "false", mockBroker);

        // create a Kafka consumer factory
        DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<String, String>(consumerProperties);

        // set the topic that needs to be consumed
        ContainerProperties containerProperties = new ContainerProperties("cidade.criado");

        // create a Kafka MessageListenerContainer
        container = new KafkaMessageListenerContainer<>(consumerFactory, containerProperties);

        // create a thread safe queue to store the received message
        records = new LinkedBlockingQueue<>();

        // setup a Kafka message listener
        container
            .setupMessageListener(new MessageListener<String, String>() {
              @Override
              public void onMessage(
                  ConsumerRecord<String, String> record) {
                records.add(record);
              }
            });

        // start the container and underlying message listener
        container.start();

        // wait until the container has the required number of assigned partitions
        ContainerTestUtils.waitForAssignment(container,
        		mockBroker.getPartitionsPerTopic());
    }

    @AfterEach
    public void tearDown() {
        container.stop();
    }
	
	
	@Test
	public void testeEnviarMensagemSucesso() throws InterruptedException {
//        Consumer<Integer, String> consumer = configureConsumer();
        
        CidadeModel model = new CidadeModel();
        model.setNome("Santo André");
        model.setPopulacao(1000000);
        model.setUf("SP");
        
//        producer.enviar(model);
//        
//        ConsumerRecord<String, String> received = records.poll(10, TimeUnit.SECONDS);
//        assertNotNull(received);
//        
//        ConsumerRecord<String, String> received = consumerRecords.poll(10, TimeUnit.SECONDS);
//        
//        assertNotNull(received);
        
//        ConsumerRecord<Integer, String> singleRecord = KafkaTestUtils.getSingleRecord(consumer, "cidade.criado");
//        
//        assertNotNull(singleRecord);
	}
	
//    private Consumer<Integer, String> configureConsumer() {
//        System.setProperty("spring.kafka.bootstrap-servers", mockBroker.getBrokersAsString());
//    	
//        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("consumer_1", "true", mockBroker);
//        
//        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        
//        Consumer<Integer, String> consumer = new DefaultKafkaConsumerFactory<Integer, String>(consumerProps)
//                .createConsumer();
//        
//        consumer.subscribe(Collections.singleton("cidade.criado"));
//        
//        return consumer;
//    }
}
