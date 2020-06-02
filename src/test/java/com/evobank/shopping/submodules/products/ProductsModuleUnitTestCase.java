package com.evobank.shopping.submodules.products;

import com.evobank.architecture.application.UnitTestCase;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.factories.ProductFactory;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ProductsModuleUnitTestCase extends UnitTestCase {

    protected ProductFactory factory;

    protected ProductsValidator searcher;

    protected IProductsRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(IProductsRepository.class);
        searcher = new ProductsValidator(repository);
        factory = new ProductFactory(searcher);
    }

    protected void whenSearchById(Product product){
        Mockito.when(repository.searchById(product.getId())).thenReturn(Optional.of(product));
    }

    protected void shouldHaveUpdated(Product product){
        verify(repository, atLeastOnce()).update(product);
    }

    public void shouldHaveSaved(Product product) {
        verify(repository, atLeastOnce()).save(product);
    }
    public void shouldHaveSearched() {
        verify(repository, atLeastOnce()).findAll();
    }
}
