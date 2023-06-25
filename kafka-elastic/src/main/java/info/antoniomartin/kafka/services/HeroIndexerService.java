package info.antoniomartin.kafka.services;

import info.antoniomartin.kafka.model.Hero;
import info.antoniomartin.kafka.model.HeroEntity;
import info.antoniomartin.kafka.repositories.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HeroIndexerService {
    private final HeroRepository repository;

    public HeroEntity createHeroIndexer(final Hero hero) {
        return repository.save(HeroEntity.builder()
                .name(hero.getName())
                .character(hero.getCharacter())
                .type(hero.getType())
                .description(hero.getDescription())
                .location(new GeoPoint(Double.parseDouble(hero.getLatitude()), Double.parseDouble(hero.getLongitude())))
                .timeStamp(System.currentTimeMillis())
                .build());
    }
}
