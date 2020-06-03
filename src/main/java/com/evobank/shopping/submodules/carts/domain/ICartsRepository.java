package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;

public interface ICartsRepository {
    void save(Cart fund);

    boolean isThereACartWithTheSameId(String value);

    void addProductToCart(ProductInCart productInCart);

    boolean isThereAProductWithId(ProductInCartProduct product);
}
