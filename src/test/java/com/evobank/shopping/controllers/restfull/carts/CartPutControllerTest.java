package com.evobank.shopping.controllers.restfull.carts;

import com.evobank.shopping.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
final class CartPutControllerTest extends ApplicationTestCase {

    @Test
    void create_a_cart() throws Exception {
        assertRequest("PUT",
                "/cart/99ad55f5-6eab-4d73-b383-c63268e251e8",
                201);
    }

    @Test
    void create_a_cart_with_characters_no_valids() throws Exception {
        assertRequest("PUT",
                "/cart/",
                404);
        assertRequest("PUT",
                "/cart/12",
                400);
        assertRequest("PUT",
                "/cart",
                404);
    }

}