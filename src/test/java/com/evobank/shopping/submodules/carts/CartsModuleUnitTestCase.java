package com.evobank.shopping.submodules.carts;

import com.evobank.architecture.application.UnitTestCase;
import com.evobank.shopping.submodules.carts.domain.Cart;
import com.evobank.shopping.submodules.carts.domain.ICartsRepository;
import com.evobank.shopping.submodules.carts.domain.ProductInCart;
import com.evobank.shopping.submodules.carts.domain.factories.CartFactory;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.ProductInCartProduct;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public abstract class CartsModuleUnitTestCase extends UnitTestCase {

    protected CartFactory factory;

    protected CartValidator searcher;

    protected ICartsRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(ICartsRepository.class);
        searcher = new CartValidator(repository);
        factory = new CartFactory(searcher);
    }

    public void shouldHaveSaved(Cart cart) {
        verify(repository, atLeastOnce()).save(cart);
    }

    protected void shouldHaveAggregate(ProductInCart productInCart) {
        verify(repository, atLeastOnce()).addProductToCart(productInCart);
    }

    protected void whenValidIfTheCartExistReturnTrue(String idCart) {
        Mockito.when(repository.isThereACartWithTheSameId(idCart)).thenReturn(true);
    }

    protected void whenValidIfTheCartExistReturnFalse(String idCart) {
        Mockito.when(repository.isThereACartWithTheSameId(idCart)).thenReturn(true);
    }

    protected void whenValidIfTheProductExistReturnTrue(String idProduct){
        Mockito.when(repository.isThereAProductWithId(ProductInCartProduct.createFromCommand(idProduct))).thenReturn(true);
    }

    protected void whenValidIfTheProductExistReturnFalse(String idProduct){
        Mockito.when(repository.isThereAProductWithId(ProductInCartProduct.createFromCommand(idProduct))).thenReturn(true);
    }
}
