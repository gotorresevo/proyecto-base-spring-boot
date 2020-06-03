package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartIdException;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductInCartProduct implements IValueObject {
    private String value;

    public static ProductInCartProduct createFromCommand(String value) {
        return new ProductInCartProduct(value);
    }

    @Override
    public void valid(IValidator finder) {
        CartValidator productsValidator = (CartValidator) finder;
        ensureIdCorrect(getValue());
        ensureThatTheProductExist(productsValidator);
    }

    private void ensureIdCorrect(String value) {
        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new CartIdException(String.format("El formato del Id '%s' no es valido", getValue()));
        }
    }

    private void ensureThatTheProductExist(CartValidator productsValidator) {
        if (!productsValidator.isThereAProductWithId(this))
            throw new ProductNotFoundException(String.format("El Id '%s' del producto no fue encontrado", getValue()));
    }
}
