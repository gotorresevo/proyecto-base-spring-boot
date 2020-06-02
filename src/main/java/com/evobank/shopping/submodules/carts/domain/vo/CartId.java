package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartIdException;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartNotFoundException;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.enums.Process;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class CartId implements IValueObject {
    private String value;
    private Process process;

    public static CartId createFromCreateCartCommand(String value) {
        return new CartId(value, Process.CREATE);
    }

    public static CartId createFromAddProductToCartCommand(String value) {
        return new CartId(value, Process.ADD_PRODUCT);
    }

    @Override
    public void valid(IValidator finder) {
        CartValidator productsValidator = (CartValidator) finder;
        ensureSetValueIfIsNull(getValue());
        ensureIdCorrect(getValue());
        if (Process.CREATE.equals(getProcess()))
            ensureThatTheCartIdDoesNotExist(productsValidator);
        if (Process.ADD_PRODUCT.equals(getProcess()))
            ensureThatTheCartIdExist(productsValidator);
    }

    private void ensureThatTheCartIdExist(CartValidator productsValidator) {
        if (!productsValidator.isThereACartWithTheSameId(this)){
            throw new CartNotFoundException(String.format("Carrito con id '%s' no encontrado", getValue()));
        }
    }

    private void ensureSetValueIfIsNull(String value) {
        if (null == value) {
            this.value = UUID.randomUUID().toString();
        }
    }

    private void ensureIdCorrect(String value) {
        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            if(Process.ADD_PRODUCT.equals(getProcess()))
                throw new CartNotFoundException(String.format("Carrito con id '%s' no encontrado", getValue()));
            throw new CartIdException(String.format("El formato del Id '%s' no es valido", getValue()));
        }
    }

    private void ensureThatTheCartIdDoesNotExist(CartValidator productsValidator) {
        if (productsValidator.isThereACartWithTheSameId(this))
            throw new CartIdException(String.format("El Id '%s' dado al producto ya existe en otro producto", getValue()));
    }
}
