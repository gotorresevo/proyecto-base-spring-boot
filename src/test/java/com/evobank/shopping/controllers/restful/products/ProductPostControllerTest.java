package com.evobank.shopping.controllers.restful.products;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ProductPostControllerTest extends ApplicationTestCase {

    @Test
    void create_a_product() throws Exception {
        assertRequestWithBody("POST",
                "/products",
                "{\"name\":\"IPhone 11 Pro\", \"stock\":10}",
                201);
    }

    @Test
    void create_a_product_with_name_incorrect() throws Exception {
        assertRequestWithBody("POST",
                "/products",
                "{\"name\":\"25\", \"stock\":10}",
                400);
    }

}