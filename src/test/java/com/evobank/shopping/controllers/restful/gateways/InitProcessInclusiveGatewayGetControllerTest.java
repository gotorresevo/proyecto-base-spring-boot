package com.evobank.shopping.controllers.restful.gateways;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessInclusiveGatewayGetControllerTest extends ApplicationTestCase {

    @Test
    void initProcessInclusiveGatewayA() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/inclusive?value=A",
                204);
    }

    @Test
    void initProcessInclusiveGatewayB() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/inclusive?value=B",
                204);
    }

    @Test
    void initProcessInclusiveGatewayC() throws Exception {
        assertRequest("GET",
                "/init-process/gateway/inclusive?value=C",
                204);
    }

}