package com.evobank.shopping.submodules.carts.domain.service;

import com.evobank.architecture.domain.service.DomainService;
import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.domain.ICartsRepository;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = {@InjectDependency})
@DomainService
public class CartValidator implements IValidator {
    private final ICartsRepository repository;

    public boolean isThereACartWithTheSameId(CartId id) {
        return repository.isThereACartWithTheSameId(id.getValue());
    }

    public boolean isThereAProductWithId(ProductInCartProduct product) {
        return repository.isThereAProductWithId(product);
    }
}
