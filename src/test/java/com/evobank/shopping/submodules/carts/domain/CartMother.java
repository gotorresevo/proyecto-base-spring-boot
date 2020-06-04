package com.evobank.shopping.submodules.carts.domain;

import com.evobank.shopping.submodules.carts.application.create.CreateCartICommand;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.carts.domain.vo.CartId;
import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;
import org.mockito.Mockito;

public final class CartMother {

    public static Cart create(CartId id, CartValidator searcher) {
        return Cart.create(id, searcher);
    }


    public static Cart fromRequest(CreateCartICommand command, CartValidator searcher) {
        return create(
            CartIdMother.createFromCreateCartCommand(command.getId()), searcher
        );
    }

    public static Cart random() {
        return create(CartIdMother.randomCreateFromCreateCartCommand(), Mockito.mock(CartValidator.class));
    }
}
