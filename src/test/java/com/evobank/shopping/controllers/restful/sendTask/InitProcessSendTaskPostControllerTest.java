package com.evobank.shopping.controllers.restful.sendTask;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessSendTaskPostControllerTest extends ApplicationTestCase {

    @Test
    void initProcessSendTask() throws Exception {
        assertRequest("POST",
                "/init-process/send-task/1",
                201);
    }

}