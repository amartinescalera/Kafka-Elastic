package info.antoniomartin.kafka.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hero {
    private String name;
    private String character;
    private String type;
    private String description;
    private String longitude;
    private String latitude;
}
