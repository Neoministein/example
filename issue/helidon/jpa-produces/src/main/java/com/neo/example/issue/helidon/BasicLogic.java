package com.neo.example.issue.helidon;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BasicLogic {

    @PersistenceContext(unitName = "mainPersistence")
    protected EntityManager em;

    @Inject
    AGenericBean aGenericBean;

    @Transactional
    public void runLogic() {
        aGenericBean.doStuff(); // <!-- Does not throw exception

        em.persist(new BasicEntity());
    }
}
