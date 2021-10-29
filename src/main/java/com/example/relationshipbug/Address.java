package com.example.relationshipbug;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@Builder
@Node
public class Address extends BaseEntity<Address> {
    private String street;

    private String city;

    private String state;
}
