package com.evobank.shopping.submodules.carts.infrastructure;

import com.evobank.architecture.infrastructure.Adapter;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.carts.domain.Cart;
import com.evobank.shopping.submodules.carts.domain.ICartsRepository;
import com.evobank.shopping.submodules.carts.domain.ProductInCart;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import com.evobank.shopping.submodules.shared.products.infrastructure.InMemoryProductsRespository;

import java.util.HashMap;
import java.util.Map;

@Adapter
public final class InMemoryCartsRepository implements ICartsRepository {
    private Map<String, Cart> map = new HashMap<>();
    private Map<String, ProductInCart> productInCartMap = new HashMap<>();
    private InMemoryProductsRespository inMemoryProductsRespository;

    @InjectDependency
    public InMemoryCartsRepository(InMemoryProductsRespository inMemoryProductsRespository){
        this.inMemoryProductsRespository =inMemoryProductsRespository;
    }

    @Override
    public void save(Cart cart) {
        map.put(cart.getId().getValue(), cart);
    }

    @Override
    public boolean isThereACartWithTheSameId(String id) {
        return null != map.get(id);
    }

    @Override
    public void addProductToCart(ProductInCart productInCart) {
        productInCartMap.put(productInCart.getProduct().getValue(), productInCart);
    }

    @Override
    public boolean isThereAProductWithId(ProductInCartProduct product) {
        return inMemoryProductsRespository.isThereAProductWithTheSameId(product.getValue());
    }
}
