package com.evobank.shopping.submodules.carts.domain.factories;

import com.evobank.architecture.domain.Factory;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.domain.Cart;
import com.evobank.shopping.submodules.carts.domain.ProductInCart;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartQuantity;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_=@InjectDependency)
@Factory
public final class CartFactory {
    private final CartValidator searcher;
    public Cart create(CartId id) {
        return Cart.create(id, searcher);
    }
    public ProductInCart create(CartId id, ProductInCartProduct product, ProductInCartQuantity quantity) {
        return ProductInCart.create(id, product, quantity, searcher);
    }
}
