package com.evobank.shopping.controllers.restfull.products;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class ProductsGetControllerTest extends ApplicationTestCase {

    @Test
    void find_all_products_with_data() throws Exception {
        String body = "[{\n" +
                "\"id\": \"99ad55f5-6eab-4d73-b383-c63268e251e8\",\n" +
                "\"name\": \"The best product\"\n" +
                "}]";

        givenThereIsAProduct("99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\n" +
                "\"name\": \"The best product\"\n" +
                "}");
        assertResponse("/products", 200, body);
    }

    @Test
    void find_all_products_with_data_empty() throws Exception {
        String body = "[]";
        assertResponse("/products", 200, body);
    }

    private void givenThereIsAProduct(String uuid, String body) throws Exception {
        assertRequestWithBody("PUT", "/products/"+uuid, body, 201);
    }

}