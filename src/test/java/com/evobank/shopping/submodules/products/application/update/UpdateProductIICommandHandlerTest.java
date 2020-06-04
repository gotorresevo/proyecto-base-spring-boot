package com.evobank.shopping.submodules.products.application.update;

import com.evobank.shopping.submodules.products.ProductsModuleUnitTestCase;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.ProductMother;
import com.evobank.shopping.submodules.products.domain.ProductUpdatedDomainEventMother;
import com.evobank.shopping.submodules.products.usecases.ProductUpdater;
import com.evobank.shopping.submodules.shared.products.domain.events.ProductUpdatedDomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UpdateProductIICommandHandlerTest extends ProductsModuleUnitTestCase {
    private UpdateProductCommandHandler handler;
    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new UpdateProductCommandHandler(new ProductUpdater(repository, IEventBus, factory));
    }

    @Test
    void update_a_product_valid() {
        UpdateProductCommand command = UpdateProductCommandMother.random();

        Product product = ProductMother.fromRequest(command, searcher);
        Product productCurrent = ProductMother.updateId(product.getId().getValue(), searcher);
        ProductUpdatedDomainEvent domainEvent = ProductUpdatedDomainEventMother.fromProduct(product);

        super.whenSearchById(productCurrent);

        handler.handle(command);

        shouldHaveUpdated(product);
        shouldHavePublished(domainEvent);
    }
}