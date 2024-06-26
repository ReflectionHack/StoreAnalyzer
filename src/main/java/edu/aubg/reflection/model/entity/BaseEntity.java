package edu.aubg.reflection.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }
}
