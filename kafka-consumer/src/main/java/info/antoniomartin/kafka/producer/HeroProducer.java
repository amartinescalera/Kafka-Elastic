package info.antoniomartin.kafka.producer;

import info.antoniomartin.kafka.model.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroProducer {

    private static final String HERO = "hero";
    private final KafkaTemplate<String, Hero> templateForHero;

    public void sendHeroToKafka(final Hero hero) {
        templateForHero.send(HERO, hero);
    }
}
