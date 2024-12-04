package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean completed;
    private Instant createdAt;
    private Instant updateAt;

    public Task() {}

    public Task(String description, boolean completed, Instant createdAt, Instant updateAt) {
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Instant getCreatedAt(){return createdAt;}

    public void setCreatedAt(Instant createdAt){this.createdAt = createdAt;}

    public Instant getUpdateAt(){return updateAt;}

    public void setUpdateAt(Instant updateAt){this.updateAt = updateAt;}

    // Métodos de ciclo de vida (para definir as datas automaticamente)
    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = Instant.now();
    }
}