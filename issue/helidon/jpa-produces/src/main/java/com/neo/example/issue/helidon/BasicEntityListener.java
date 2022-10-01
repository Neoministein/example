package com.neo.example.issue.helidon;

import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;

public class BasicEntityListener {

    @Inject
    protected AGenericBean aGenericBean;

    @PrePersist
    public void prePersist(BasicEntity basicEntity) {
        aGenericBean.doStuff(); // <-- Throws exception
    }
}