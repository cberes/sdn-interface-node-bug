package com.example.relationshipbug;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@Builder
@Node
public class Bank extends BaseEntity<Bank> {
    private String name;
}
