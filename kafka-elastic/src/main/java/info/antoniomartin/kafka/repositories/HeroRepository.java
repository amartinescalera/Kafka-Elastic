package info.antoniomartin.kafka.repositories;

import info.antoniomartin.kafka.model.HeroEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface HeroRepository extends ElasticsearchRepository<HeroEntity, String> {

}
