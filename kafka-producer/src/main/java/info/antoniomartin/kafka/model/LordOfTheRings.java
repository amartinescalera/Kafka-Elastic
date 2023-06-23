package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LordOfTheRings {
    private final String name;
    private final String character;
    private final Location location;
}
