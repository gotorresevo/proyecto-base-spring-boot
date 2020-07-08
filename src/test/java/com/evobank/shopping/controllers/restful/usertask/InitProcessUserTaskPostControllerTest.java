package com.evobank.shopping.controllers.restful.usertask;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessUserTaskPostControllerTest extends ApplicationTestCase {

    @Test
    void initProcessUserTask() throws Exception {
        assertRequest("POST",
                "/init-process/user-task/1",
                201);
    }

}