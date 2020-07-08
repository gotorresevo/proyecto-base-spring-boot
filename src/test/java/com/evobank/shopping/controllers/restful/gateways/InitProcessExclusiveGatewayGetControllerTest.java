package com.evobank.shopping.controllers.restful.gateways;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessExclusiveGatewayGetControllerTest extends ApplicationTestCase {

    @Test
    void initProcessExclusiveGatewayA() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/exclusive?value=A",
                204);
    }

    @Test
    void initProcessExclusiveGatewayB() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/exclusive?value=B",
                204);
    }

    @Test
    void initProcessExclusiveGatewayC() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/exclusive?value=C",
                204);
    }

}