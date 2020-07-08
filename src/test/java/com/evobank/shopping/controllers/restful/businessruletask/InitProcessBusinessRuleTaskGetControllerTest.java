package com.evobank.shopping.controllers.restful.businessruletask;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class InitProcessBusinessRuleTaskGetControllerTest extends ApplicationTestCase {

    @Test
    void initProcessBusinessRuleTask() throws Exception {
        String body = "" +
                "{" +
                "    \"result\": [" +
                "        \"Filete Gourment Envejecido En Seco\"," +
                "        \"Filete\"" +
                "    ]" +
                "}";
        assertResponse("/init-process/business-rule-task?var1=Primavera&var2=5", 200, body);
    }

}