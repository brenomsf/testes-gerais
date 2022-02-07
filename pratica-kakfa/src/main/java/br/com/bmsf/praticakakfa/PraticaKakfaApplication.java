package br.com.bmsf.praticakakfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;

@SpringBootApplication
@EnableKafka
@EnableAsync
public class PraticaKakfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticaKakfaApplication.class, args);
	}

	@Bean
	public io.opentracing.Tracer initTracer() {
	  SamplerConfiguration samplerConfig = new SamplerConfiguration().withType("const").withParam(1);
	  ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv().withLogSpans(true);
	  return Configuration.fromEnv("service-a").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}
}
