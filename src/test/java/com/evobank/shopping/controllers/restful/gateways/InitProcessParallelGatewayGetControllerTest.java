package com.evobank.shopping.controllers.restful.gateways;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessParallelGatewayGetControllerTest extends ApplicationTestCase {

    @Test
    void initProcessExlusiveGatewayA() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/parallel",
                204);
    }

    @Test
    void initProcessExlusiveGatewayB() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/parallel",
                204);
    }

    @Test
    void initProcessExlusiveGatewayC() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/parallel",
                204);
    }

}