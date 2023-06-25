package info.antoniomartin.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "hero")
public class HeroEntity {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Text, name = "character")
    private String character;

    @Field(type = FieldType.Text, name = "type")
    private String type;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @GeoPointField
    private GeoPoint location;

    @Field(type = FieldType.Date, name = "@timeStamp")
    private Long timeStamp;
}
