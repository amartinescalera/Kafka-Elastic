package info.antoniomartin.kafka.service;

import info.antoniomartin.kafka.model.Hero;
import info.antoniomartin.kafka.model.Hobbit;
import info.antoniomartin.kafka.model.LeagueOfLegends;
import info.antoniomartin.kafka.producer.HeroProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class LolService {

    private final HeroProducer heroProducer;

    public void unify(final LeagueOfLegends lol) {
        final Hero hero = Hero.builder()
            .name(lol.getName())
            .type("LeagueOfLegends")
            .character(lol.getMasteries())
            .description(lol.getChampion())
            .longitude(lol.getLocation().getLongitude())
            .latitude(lol.getLocation().getLatitude())
            .build();

        log.info("Create a new Hero: {}'", hero.toString());
        heroProducer.sendHeroToKafka(hero);
    }
}
