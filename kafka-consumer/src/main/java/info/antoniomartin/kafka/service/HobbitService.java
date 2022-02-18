package info.antoniomartin.kafka.service;

import info.antoniomartin.kafka.model.Hero;
import info.antoniomartin.kafka.model.Hobbit;
import info.antoniomartin.kafka.producer.HeroProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class HobbitService {

    private final HeroProducer heroProducer;

    public void unify(final Hobbit hobbit) {
        final Hero hero = Hero.builder()
            .name(hobbit.getName())
            .type("Hobbit")
            .character(hobbit.getCharacter())
            .description(hobbit.getCharacter())
            .longitude(hobbit.getLocation().getLongitude())
            .latitude(hobbit.getLocation().getLatitude())
            .build();

        log.info("Create a new Hero: {}'", hero.toString());
        heroProducer.sendHeroToKafka(hero);
    }
}
