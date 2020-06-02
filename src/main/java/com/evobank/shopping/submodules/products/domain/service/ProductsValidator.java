package com.evobank.shopping.submodules.products.domain.service;

import com.evobank.architecture.domain.service.DomainService;
import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;
import com.evobank.shopping.submodules.products.domain.vo.ProductName;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@DomainService
public class ProductsValidator implements IValidator {
    private final IProductsRepository repository;

    public boolean isThereAProductWithTheSameName(ProductName name) {
        return repository.isThereAProductWithTheSameName(name.getValue());
    }

    public boolean isThereAProductWithTheSameId(ProductId id) {
        return repository.isThereAProductWithTheSameId(id.getValue());
    }
}
