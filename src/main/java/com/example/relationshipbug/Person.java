package com.example.relationshipbug;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node
public class Person extends BaseEntity<Person> {
    private String name;

    private String excludedFromProjection;

    private int age;

    private boolean active;

    @Relationship("LIVES_AT")
    private Address address;
}
