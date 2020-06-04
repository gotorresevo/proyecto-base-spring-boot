package com.evobank.shopping.submodules.carts.application.create;

import com.evobank.shopping.submodules.carts.domain.vo.CartIdMother;

public final class CreateCartCommandMother {
    public static CreateCartCommand create(String id) {
        return new CreateCartCommand(id);
    }

    public static CreateCartCommand random() {
        return create(CartIdMother.randomCreateFromCreateCartCommand().getValue());
    }

    public static CreateCartCommand createId(String id) {
        return new CreateCartCommand(id);
    }
}
