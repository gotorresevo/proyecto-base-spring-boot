package com.evobank.shopping.controllers.restful.receivetask;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ContinueProcessReceiveTaskPostControllerTest extends ApplicationTestCase {

    @Test
    void continueProcessReceiveTask() throws Exception {
        assertRequest("POST",
                "/init-process/receive-task/1",
                201);
        assertRequest("POST",
                "/continue-process/receive-task/1",
                201);
    }

}