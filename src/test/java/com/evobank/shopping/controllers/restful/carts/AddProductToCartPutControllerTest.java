package com.evobank.shopping.controllers.restful.carts;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class AddProductToCartPutControllerTest extends ApplicationTestCase {

    @Test
    void add_a_product_to_cart() throws Exception {
        givenThereIsAProduct("59ad55f5-6eab-4d73-b383-c63268e251e7",
                "{\n" +
                        "\"name\": \"IPhone X\", \"stock\":10" +
                        "}");
        givenThereIsACart("99ad55f5-6eab-4d73-b383-c63268e251e8");
        assertRequest("PUT",
                "/cart/99ad55f5-6eab-4d73-b383-c63268e251e8/product/59ad55f5-6eab-4d73-b383-c63268e251e7",
                201);
    }

    @Test
    void add_a_product_to_cart_with_id_cart_no_exist() throws Exception {
        givenThereIsAProduct("59ad55f5-6eab-4d73-b383-c63268e251e7",
                "{\n" +
                        "\"name\": \"IPhone X\", \"stock\":10" +
                        "}");
        assertRequest("PUT",
                "/cart/99ad55f5-6eab-4d73-b383-c63268e251e8/product/59ad55f5-6eab-4d73-b383-c63268e251e7",
                404);
    }

    @Test
    void add_a_product_to_cart_with_id_product_no_exist() throws Exception {
        givenThereIsACart("99ad55f5-6eab-4d73-b383-c63268e251e8");
        assertRequest("PUT",
                "/cart/99ad55f5-6eab-4d73-b383-c63268e251e8/product/59ad55f5-6eab-4d73-b383-c63268e251e7",
                404);
    }

    private void givenThereIsACart(String uuid) throws Exception {
        assertRequest("PUT", "/cart/" + uuid, 201);
    }

    private void givenThereIsAProduct(String uuid, String body) throws Exception {
        assertRequestWithBody("PUT", "/products/" + uuid, body, 201);
    }

}