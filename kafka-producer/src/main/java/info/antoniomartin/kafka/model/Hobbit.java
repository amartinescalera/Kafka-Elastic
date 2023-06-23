package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Hobbit {
    private final String name;
    private final String character;
    private final String thorinsCompany;
    private final Location location;
}
