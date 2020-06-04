package com.evobank.shopping.submodules.carts.application.create;

import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.shopping.submodules.carts.CartsModuleUnitTestCase;
import com.evobank.shopping.submodules.carts.domain.Cart;
import com.evobank.shopping.submodules.carts.domain.CartCreatedDomainEventMother;
import com.evobank.shopping.submodules.carts.domain.CartMother;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartIdException;
import com.evobank.shopping.submodules.carts.usecases.CartCreator;
import com.evobank.shopping.submodules.shared.carts.domain.events.CartCreatedDomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class CreateCartIICommandHandlerTest extends CartsModuleUnitTestCase {

    private CreateCartICommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateCartICommandHandler(new CartCreator(repository, IEventBus, factory));
    }

    @Test
    void create_a_product_valid() {
        CreateCartICommand command = CreateCartCommandMother.random();

        Cart product = CartMother.fromRequest(command, searcher);
        CartCreatedDomainEvent domainEvent = CartCreatedDomainEventMother.fromCart(product);

        handler.handle(command);

        shouldHaveSaved(product);
        shouldHavePublished(domainEvent);
    }

    @Test
    void create_a_cart_with_Id_no_valids() {
        Consumer<String> consumer = (value) -> {
            try {
                handler.handle(CreateCartCommandMother.createId(value));
            } catch (DomainException creatorException) {
                for (RuntimeException runtimeException : creatorException.getExceptions()) {
                    if (runtimeException instanceof CartIdException) {
                        throw (CartIdException) runtimeException;
                    }
                }
            }
        };
        Assertions.assertThrows(CartIdException.class, () -> consumer.accept(""));
        Assertions.assertThrows(CartIdException.class, () -> consumer.accept("5456"));
    }
}