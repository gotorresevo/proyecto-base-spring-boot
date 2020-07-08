package com.evobank.shopping.controllers.restful.receivetask;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessReceiveTaskPostControllerTest extends ApplicationTestCase {

    @Test
    void initProcessReceiveTask() throws Exception {
        assertRequest("POST",
                "/init-process/receive-task/1",
                201);
    }

}