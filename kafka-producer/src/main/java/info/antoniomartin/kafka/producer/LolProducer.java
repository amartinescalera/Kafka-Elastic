package info.antoniomartin.kafka.producer;

import com.github.javafaker.Faker;
import info.antoniomartin.kafka.model.LeagueOfLegends;
import info.antoniomartin.kafka.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LolProducer {

    private static final String LOL = "leagueOfLegends";
    private final KafkaTemplate<String, LeagueOfLegends> templateForLol;
    private final Faker faker;


    @Scheduled(fixedRate = 1000)
    public void generateLol() {
        final LeagueOfLegends lol = LeagueOfLegends.builder()
            .name(faker.name().name())
            .champion(faker.leagueOfLegends().champion())
            .masteries(faker.leagueOfLegends().masteries())
            .quote(faker.leagueOfLegends().quote())
            .rank(faker.leagueOfLegends().rank())
            .summonerSpell(faker.leagueOfLegends().summonerSpell())
            .location(Location.builder().latitude(faker.address().latitude()).longitude(faker.address().longitude()).build())
            .build();

        templateForLol.send(LOL, faker.random().hex(20), lol);
    }
}
