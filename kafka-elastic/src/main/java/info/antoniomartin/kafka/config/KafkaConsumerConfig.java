package info.antoniomartin.kafka.config;

import info.antoniomartin.kafka.model.Hero;
import info.antoniomartin.kafka.services.HeroIndexerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class KafkaConsumerConfig {

    @Bean
    public Consumer<Hero> readMessage(HeroIndexerService heroIndexerService) {
        return hero -> {
            log.info("Received USM message from kafka. msg=[{}]", hero);
            heroIndexerService.createHeroIndexer(hero);
        };
    }
}
