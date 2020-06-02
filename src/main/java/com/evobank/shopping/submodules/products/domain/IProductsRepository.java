package com.evobank.shopping.submodules.products.domain;

import com.evobank.shopping.submodules.products.domain.vo.ProductId;

import java.util.Optional;
import java.util.stream.Stream;

public interface IProductsRepository {
    void save(Product fund);

    boolean isThereAProductWithTheSameName(String value);

    boolean isThereAProductWithTheSameId(String value);

    Stream<Product> findAll();

    Optional<Product> searchById(ProductId id);

    void update(Product product);
}
