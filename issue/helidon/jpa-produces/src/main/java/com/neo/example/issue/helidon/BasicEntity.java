package com.neo.example.issue.helidon;

import jakarta.persistence.*;

@Entity
@Table
@EntityListeners(BasicEntityListener.class)
public class BasicEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public BasicEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
