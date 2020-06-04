package com.evobank.shopping.submodules.products.application.create;

import com.evobank.architecture.domain.exceptions.DomainException;
import com.evobank.shopping.submodules.products.ProductsModuleUnitTestCase;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.ProductCreatedDomainEventMother;
import com.evobank.shopping.submodules.products.domain.ProductMother;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductIdException;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductNameException;
import com.evobank.shopping.submodules.products.usecases.ProductCreator;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductCreatedDomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class CreateProductIICommandHandlerTest extends ProductsModuleUnitTestCase {

    private CreateProductICommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateProductICommandHandler(new ProductCreator(repository, IEventBus, factory));
    }

    @Test
    void create_a_product_valid() {
        CreateProductICommand command = CreateProductCommandMother.random();

        Product product = ProductMother.fromRequest(command, searcher);
        ProductCreatedDomainEvent domainEvent = ProductCreatedDomainEventMother.fromProduct(product);

        handler.handle(command);

        shouldHaveSaved(product);
        shouldHavePublished(domainEvent);
    }

    @Test
    void create_a_product_with_Id_no_valids() {
        Consumer<String> consumer = (value) -> {
            try {
                handler.handle(CreateProductCommandMother.createId(value));
            } catch (DomainException creatorException) {
                for (RuntimeException runtimeException : creatorException.getExceptions()) {
                    if (runtimeException instanceof ProductIdException) {
                        throw (ProductIdException) runtimeException;
                    }
                }
            }
        };
        Assertions.assertThrows(ProductIdException.class, () -> consumer.accept(""));
        Assertions.assertThrows(ProductIdException.class, () -> consumer.accept("5456"));
    }

    @Test
    void create_a_product_with_name_no_valids() {
        Consumer<String> consumer = (value) -> {
            try {
                handler.handle(CreateProductCommandMother.createName(value));
            } catch (DomainException creatorException) {
                for (RuntimeException runtimeException : creatorException.getExceptions()) {
                    if (runtimeException instanceof ProductNameException) {
                        throw (ProductNameException) runtimeException;
                    }
                }
            }
        };
        Assertions.assertThrows(ProductNameException.class, () -> consumer.accept(""));
        Assertions.assertThrows(ProductNameException.class, () -> consumer.accept("5456"));
        Assertions.assertThrows(ProductNameException.class, () -> consumer.accept(null));
    }

}