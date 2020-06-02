package com.evobank.shopping.controllers.restfull.products;

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
                        "\"name\": \"IPhone X\"\n" +
                        "}");
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\"name\":\"IPhone 11 Pro\"}",
                201);
        assertResponse("/products", 200, body);
    }

    private void givenThereIsAProduct(String uuid, String body) throws Exception {
        assertRequestWithBody("PUT", "/products/"+uuid, body, 201);
    }

    /*@Test
    void create_two_product_with_the_same_name() throws Exception {
        assertRequestWithBody("PATCH",
                "/products/98ad55f5-6eab-4d73-b383-c63268e251e8",
                "{\"name\":\"SameName\"}",
                201);
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e7",
                "{\"name\":\"SameName\"}",
                400);
    }

    @Test
    void create_a_product_with_characters_no_valids() throws Exception {
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e1",
                "{\"name\":\"\"}",
                400);
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e2",
                "{\"name\":12}",
                400);
        assertRequestWithBody("PATCH",
                "/products/99ad55f5-6eab-4d73-b383-c63268e251e4",
                "{}",
                400);
    }*/

}