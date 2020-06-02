package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;

import java.util.Optional;
import java.util.stream.Stream;

public interface ICartsRepository {
    void save(Cart fund);

    boolean isThereACartWithTheSameId(String value);

    Stream<Cart> findAll();

    Optional<Cart> searchById(CartId id);

    void update(Cart product);

    boolean isThereAProductAggregateWithTheSameId(ProductInCartProduct productInCartProduct);

    void addProductToCart(ProductInCart productInCart);

    boolean isThereAProductWithId(ProductInCartProduct product);
}
