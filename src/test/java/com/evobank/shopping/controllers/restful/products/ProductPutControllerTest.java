package com.evobank.shopping.controllers.restful.products;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ProductPutControllerTest extends ApplicationTestCase {

    @Test
    void create_a_product() throws Exception {
        assertRequestWithBody("PUT",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\"name\":\"IPhone 11 Pro\"}",
                201);
    }

    @Test
    void create_two_product_with_the_same_name() throws Exception {
        assertRequestWithBody("PUT",
                "/products/98ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\"name\":\"SameName\"}",
                201);
        assertRequestWithBody("PUT",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e7",
                "{\"name\":\"SameName\"}",
                400);
    }

    @Test
    void create_a_product_with_characters_no_valids() throws Exception {
        assertRequestWithBody("PUT",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e1",
                "{\"name\":\"\"}",
                400);
        assertRequestWithBody("PUT",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e2",
                "{\"name\":12}",
                400);
        assertRequestWithBody("PUT",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e4",
                "{}",
                400);
    }

}