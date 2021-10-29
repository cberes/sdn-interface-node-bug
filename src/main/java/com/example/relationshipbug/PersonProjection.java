package com.example.relationshipbug;

public interface PersonProjection {
    String getName();

    int getAge();

    boolean isActive();

    AddressProjection getAddress();
}
