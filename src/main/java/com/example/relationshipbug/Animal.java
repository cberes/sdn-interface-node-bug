package com.example.relationshipbug;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.DynamicLabels;
import org.springframework.data.neo4j.core.schema.Node;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Node
public abstract class Animal extends BaseEntity<Animal> {
    private String name;

    @DynamicLabels
    private Set<String> labels = new TreeSet<>();
}
