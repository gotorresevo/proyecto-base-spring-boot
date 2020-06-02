package com.evobank.shopping.submodules.shared.products.infrastructure;

import com.evobank.architecture.infrastructure.Adapter;
import com.evobank.shopping.submodules.products.domain.IProductsRepository;
import com.evobank.shopping.submodules.products.domain.Product;
import com.evobank.shopping.submodules.products.domain.vo.ProductId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Adapter
public final class InMemoryProductsRespository implements IProductsRepository {
    Map<String, Product> map = new HashMap<>();
    @Override
    public void save(Product product) {
        map.put(product.getId().getValue(), product);
    }

    @Override
    public boolean isThereAProductWithTheSameName(String name) {
        return map.values().stream().anyMatch(product -> name.equals(product.getName().getValue()));
    }

    @Override
    public boolean isThereAProductWithTheSameId(String id) {
        return null != map.get(id);
    }

    @Override
    public Stream<Product> findAll() {
        return map.values().stream();
    }

    @Override
    public Optional<Product> searchById(ProductId id) {
        return Optional.ofNullable(map.get(id.getValue()));
    }

    @Override
    public void update(Product product) {
        this.save(product);
    }
}
