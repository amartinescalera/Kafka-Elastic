package info.antoniomartin.kafka.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Location {
    String latitude;
    String longitude;
}
