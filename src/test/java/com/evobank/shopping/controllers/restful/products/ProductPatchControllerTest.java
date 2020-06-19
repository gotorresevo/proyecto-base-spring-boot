package com.evobank.shopping.controllers.restful.products;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ProductPatchControllerTest extends ApplicationTestCase {

    @Test
    void update_a_product() throws Exception {
        String body = "[{\n" +
                "\"id\": \"99ad55f5-6eab-4d73-b383-c63268e251e8\",\n" +
                "\"name\": \"IPhone 11 Pro\"\n" +
                "}]";
        givenThereIsAProduct("99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\n" +
                        "\"name\": \"IPhone X\", \"stock\":10" +
                        "}");
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\"name\":\"IPhone 11 Pro\", \"stock\":10}",
                201);
        assertResponse("/products", 200, body);
    }

    @Test
    void update_a_product_with_name_incorrect() throws Exception {
        givenThereIsAProduct("99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\n" +
                        "\"name\": \"IPhone X\", \"stock\":10" +
                        "}");
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\"name\":\"25\", \"stock\":10}",
                400);
    }

    @Test
    void update_a_product_no_exist() throws Exception {
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e7",
                "{\"name\":\"ProductNoExist\", \"stock\":10}",
                404);
    }

    private void givenThereIsAProduct(String uuid, String body) throws Exception {
        assertRequestWithBody("PUT", "/products/"+uuid, body, 201);
    }

}