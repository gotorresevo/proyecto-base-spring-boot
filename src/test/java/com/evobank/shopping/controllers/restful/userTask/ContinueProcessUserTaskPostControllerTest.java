package com.evobank.shopping.controllers.restful.userTask;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ContinueProcessUserTaskPostControllerTest extends ApplicationTestCase {

    @Test
    void continueProcessUserTask() throws Exception {
        assertRequest("POST",
                "/init-process/user-task/1",
                201);
        assertRequest("POST",
                "/continue-process/user-task/1",
                201);
    }

}