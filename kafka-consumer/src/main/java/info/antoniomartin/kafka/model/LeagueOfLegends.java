package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeagueOfLegends {

    private String name;
    private String champion;
    private String masteries;
    private String quote;
    private String rank;
    private String summonerSpell;
    private Location location;
}
