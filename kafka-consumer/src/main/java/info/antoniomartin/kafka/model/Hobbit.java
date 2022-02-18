package info.antoniomartin.kafka.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hobbit {
    private String name;
    private String character;
    private String thorinsCompany;
    private Location location;
}
