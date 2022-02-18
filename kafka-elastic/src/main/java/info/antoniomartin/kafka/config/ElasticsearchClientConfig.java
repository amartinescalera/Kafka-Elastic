package info.antoniomartin.kafka.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "info.antoniomartin.kafka.repositories")
@ComponentScan(basePackages = "info.antoniomartin.kafka")
public class ElasticsearchClientConfig extends AbstractElasticsearchConfiguration
{

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient ()
    {
        final ClientConfiguration clientConfiguration =
                ClientConfiguration.builder().connectedTo("localhost:9200").build();

        return RestClients.create(clientConfiguration).rest();
    }
}
