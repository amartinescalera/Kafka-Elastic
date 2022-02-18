package info.antoniomartin.kafka.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {
    private String latitude;
    private String longitude;
}
