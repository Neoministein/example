package com.neo.example.issue.helidon;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@HelidonTest
class IssueTest {

    @Inject
    BasicLogic basicLogic;

    @Inject
    GenericBeanProducer genericBeanProducer;

    @Test
    void runTest() {
        genericBeanProducer.setAGenericBean(new AGenericBean());

        basicLogic.runLogic();
    }
}
