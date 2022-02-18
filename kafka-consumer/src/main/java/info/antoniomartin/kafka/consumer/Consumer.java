package info.antoniomartin.kafka.consumer;

import info.antoniomartin.kafka.model.Hobbit;
import info.antoniomartin.kafka.model.LeagueOfLegends;
import info.antoniomartin.kafka.model.LordOfTheRings;
import info.antoniomartin.kafka.service.HobbitService;
import info.antoniomartin.kafka.service.LolService;
import info.antoniomartin.kafka.service.LorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class Consumer {

    private final HobbitService hobbitService;
    private final LorService lorService;
    private final LolService lolService;

    @KafkaListener(topics = {"hobbit"}, groupId = "spring-boot-kafka")
    public void consume1(ConsumerRecord<String, Hobbit> hobbitRecord) {
        log.info("{} - Serialize a new 'hobbit' character: {}", hobbitRecord.key(), hobbitRecord.value());
        hobbitService.unify(hobbitRecord.value());
    }

    @KafkaListener(topics = {"leagueOfLegends"}, groupId = "spring-boot-kafka")
    public void consume2(ConsumerRecord<String, LeagueOfLegends> lolRecord) {
        log.info("{} - Serialize a new 'LeagueOfLegends' character: {}", lolRecord.key(), lolRecord.value());
        lolService.unify(lolRecord.value());
    }

    @KafkaListener(topics = {"lordOfTheRings"}, groupId = "spring-boot-kafka")
    public void consume3(ConsumerRecord<String, LordOfTheRings> lordRecord) {
        log.info("{} - Serialize a new 'lordOfTheRings' character: {}", lordRecord.key(), lordRecord.value());
        lorService.unify(lordRecord.value());
    }

}
