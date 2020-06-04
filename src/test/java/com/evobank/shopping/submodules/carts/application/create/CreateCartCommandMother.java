package com.evobank.shopping.submodules.carts.application.create;

import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;

public final class CreateCartCommandMother {
    public static CreateCartICommand create(String id) {
        return new CreateCartICommand(id);
    }

    public static CreateCartICommand random() {
        return create(CartIdMother.randomCreateFromCreateCartCommand().getValue());
    }

    public static CreateCartICommand createId(String id) {
        return new CreateCartICommand(id);
    }
}
