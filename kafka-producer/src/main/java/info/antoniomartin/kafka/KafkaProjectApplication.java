package info.antoniomartin.kafka;

import com.github.javafaker.Faker;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProjectApplication.class, args);
    }

    @Bean
    NewTopic hobbit() {
        return TopicBuilder.name("hobbit").partitions(1).replicas(1).build();
    }

    @Bean
    NewTopic leagueOfLegends() {
        return TopicBuilder.name("leagueOfLegends").partitions(1).replicas(1).build();
    }

    @Bean
    NewTopic lordOfTheRings() {
        return TopicBuilder.name("lordOfTheRings").partitions(1).replicas(1).build();
    }

    @Bean
    Faker faker() {
        return new Faker();
    }
}
