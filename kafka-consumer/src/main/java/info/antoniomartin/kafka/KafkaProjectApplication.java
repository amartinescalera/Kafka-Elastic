package info.antoniomartin.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProjectApplication.class, args);
    }

    @Bean
    NewTopic heroes() {
        return TopicBuilder.name("hero").partitions(1).replicas(1).build();
    }
}
