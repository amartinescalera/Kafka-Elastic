package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LordOfTheRings {
    private String name;
    private String character;
    private Location location;
}
