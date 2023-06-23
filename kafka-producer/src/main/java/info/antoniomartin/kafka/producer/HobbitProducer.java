package info.antoniomartin.kafka.producer;

import com.github.javafaker.Faker;
import info.antoniomartin.kafka.model.Hobbit;
import info.antoniomartin.kafka.model.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HobbitProducer {

    private static final String HOBBIT = "hobbit";
    private final KafkaTemplate<String, Hobbit> templateForHobbit;
    private final Faker faker;

    @Scheduled(fixedRate = 1000)
    public void generateHobbit() {
        final Hobbit hobbit = Hobbit.builder()
            .name(faker.name().name())
            .location(Location.builder().latitude(faker.address().latitude()).longitude(faker.address().longitude()).build())
            .character(faker.hobbit().character())
            .thorinsCompany(faker.hobbit().thorinsCompany())
            .build();

        templateForHobbit.send(HOBBIT, faker.random().hex(20), hobbit);
    }
}
