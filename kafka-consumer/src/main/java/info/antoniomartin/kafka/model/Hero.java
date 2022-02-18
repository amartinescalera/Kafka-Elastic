package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
    private final String name;
    private final String character;
    private final String type;
    private final String description;
    private final String longitude;
    private final String latitude;
}
