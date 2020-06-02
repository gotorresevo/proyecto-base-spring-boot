package com.evobank.shopping.submodules.products.usecases;

import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@CaseOfUse
public final class ProductsSearcher {
    private final IProductsRepository productRepository;

    public Stream<Product> search() {
        return productRepository.findAll();
    }
}
