package info.antoniomartin.kafka.service;

import info.antoniomartin.kafka.model.Hero;
import info.antoniomartin.kafka.model.LeagueOfLegends;
import info.antoniomartin.kafka.model.LordOfTheRings;
import info.antoniomartin.kafka.producer.HeroProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class LorService {

    private final HeroProducer heroProducer;

    public void unify(final LordOfTheRings lotr) {
        final Hero hero = Hero.builder()
            .name(lotr.getName())
            .type("LordOfTheRings")
            .description(lotr.getCharacter())
            .character(lotr.getCharacter())
            .longitude(lotr.getLocation().getLongitude())
            .latitude(lotr.getLocation().getLatitude())
            .build();

        log.info("Create a new Hero: {}'", hero.toString());
        heroProducer.sendHeroToKafka(hero);
    }
}
