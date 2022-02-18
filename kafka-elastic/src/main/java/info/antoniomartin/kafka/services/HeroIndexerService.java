package info.antoniomartin.kafka.services;

import info.antoniomartin.kafka.model.Hero;
import info.antoniomartin.kafka.model.HeroEntity;
import info.antoniomartin.kafka.repositories.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class HeroIndexerService {
    private final HeroRepository repository;
//    private final SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    //privateDate date = new Date(System.currentTimeMillis());

    //System.out.println(formatter.format(date));
    public HeroEntity createHeroIndexer(final Hero hero) {
        return repository.save(HeroEntity.builder()
            .name(hero.getName())
            .character(hero.getCharacter())
            .type(hero.getType())
            .description(hero.getDescription())
            .location(format("%s,%s",hero.getLatitude(),hero.getLongitude()))
            .timeStamp(System.currentTimeMillis())
            .build());
    }


}
