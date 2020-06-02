package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.shopping.submodules.carts.CartsModuleUnitTestCase;
import com.evobank.shopping.submodules.carts.domain.ProductAggregateToCartDomainEventMother;
import com.evobank.shopping.submodules.carts.domain.ProductInCart;
import com.evobank.shopping.submodules.carts.domain.ProductInCartMother;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartNotFoundException;
import com.evobank.shopping.submodules.carts.usecases.ProductAggregatorToCart;
import com.evobank.shopping.submodules.shared.carts.domain.events.ProductAggregateToCartDomainEvent;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class AddProductToCartCommandHandlerTest extends CartsModuleUnitTestCase {

    private AddProductToCartCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new AddProductToCartCommandHandler(new ProductAggregatorToCart(repository, eventBus, factory));
    }

    @Test
    void add_a_product_valid() {
        AddProductToCartCommand command = AddProductToCartCommandMother.random();
        super.whenValidIfTheProductExistReturnTrue(command.getIdProduct());
        super.whenValidIfTheCartExistReturnTrue(command.getIdCart());
        ProductInCart productInCart = ProductInCartMother.fromRequest(command, searcher);
        ProductAggregateToCartDomainEvent domainEvent = ProductAggregateToCartDomainEventMother.fromProductInCart(productInCart);

        handler.handle(command);

        super.shouldHaveAggregate(productInCart);
        shouldHavePublished(domainEvent);
    }

    @Test
    void add_a_product_with_Id_Cart_no_valids() {
        Consumer<String> consumer = (value) -> {
            try {
                handler.handle(AddProductToCartCommandMother.createIdCart(value));
            } catch (DomainException creatorException) {
                for (RuntimeException runtimeException : creatorException.getExceptions()) {
                    if (runtimeException instanceof CartNotFoundException) {
                        throw (CartNotFoundException) runtimeException;
                    }
                }
            }
        };
        Assertions.assertThrows(CartNotFoundException.class, () -> {
            super.whenValidIfTheCartExistReturnFalse("");
            consumer.accept("");
        });
        Assertions.assertThrows(CartNotFoundException.class, () -> {
            super.whenValidIfTheCartExistReturnFalse("5456");
            consumer.accept("5456");
        });
    }

    @Test
    void add_a_product_with_Id_Product_no_valids() {

        Consumer<String> consumer = (value) -> {
            try {
                handler.handle(AddProductToCartCommandMother.createIdCart(value));
            } catch (DomainException creatorException) {
                for (RuntimeException runtimeException : creatorException.getExceptions()) {
                    if (runtimeException instanceof ProductNotFoundException) {
                        throw (ProductNotFoundException) runtimeException;
                    }
                }
            }
        };
        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            super.whenValidIfTheProductExistReturnFalse("");
            consumer.accept("");
        });
        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            super.whenValidIfTheProductExistReturnFalse("5456");
            consumer.accept("5456");
        });
    }
}