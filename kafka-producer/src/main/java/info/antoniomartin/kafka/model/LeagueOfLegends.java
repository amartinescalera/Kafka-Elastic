package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LeagueOfLegends {

    private final String name;
    private final String champion;
    private final String masteries;
    private final String quote;
    private final String rank;
    private final String summonerSpell;
    private final Location location;
}
