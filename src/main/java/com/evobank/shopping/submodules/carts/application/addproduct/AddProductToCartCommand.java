package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.architecture.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class AddProductToCartCommand implements Command {
    private String idCart;
    private String idProduct;
}
