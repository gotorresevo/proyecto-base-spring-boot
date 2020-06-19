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

import java.util.List;
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
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
        CartValidator productsValidator = (CartValidator) validator;
        ensureIdCorrect(getValue());
        if (Process.ADD_PRODUCT.equals(getProcess()))
            ensureThatTheCartIdExist(productsValidator);
    }

    private void ensureThatTheCartIdExist(CartValidator productsValidator) {
        if (!productsValidator.isThereACartWithTheSameId(this)){
            throw new CartNotFoundException(String.format("Carrito con id '%s' no encontrado", getValue()));
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
}
