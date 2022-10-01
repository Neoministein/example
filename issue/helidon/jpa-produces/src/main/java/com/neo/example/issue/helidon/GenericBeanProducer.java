package com.neo.example.issue.helidon;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class GenericBeanProducer {


    protected AGenericBean aGenericBean = null;

    @Produces
    public AGenericBean getAGenericBean() {
        return aGenericBean;
    }


    public void setAGenericBean(AGenericBean aGenericBean) {
        this.aGenericBean = aGenericBean;
    }
}
