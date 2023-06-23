package info.antoniomartin.kafka.producer;

import com.github.javafaker.Faker;
import info.antoniomartin.kafka.model.Location;
import info.antoniomartin.kafka.model.LordOfTheRings;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LordProducer {

    private static final String LOR = "lordOfTheRings";
    private final KafkaTemplate<String, LordOfTheRings> templateForLor;
    private final Faker faker;

    @Scheduled(fixedRate = 1000)
    public void generateLor() {
        final LordOfTheRings lor = LordOfTheRings.builder()
            .name(faker.name().name())
            .character(faker.lordOfTheRings().character())
            .location(Location.builder().latitude(faker.address().latitude()).longitude(faker.address().longitude()).build())
            .build();

        templateForLor.send(LOR, faker.random().hex(20), lor);
    }
}
