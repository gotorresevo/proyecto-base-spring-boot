package com.evobank.shopping.controllers.restful.subprocess.callactivity;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessCallActivityPostControllerTest extends ApplicationTestCase {

    @Test
    void initProcessCallActivity() throws Exception {
        assertRequest("POST",
                "/init-process/call-activity/1",
                201);
    }

}