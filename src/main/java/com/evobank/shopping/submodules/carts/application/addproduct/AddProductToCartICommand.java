package com.evobank.shopping.submodules.carts.application.addproduct;

import com.evobank.architecture.domain.bus.command.ICommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class AddProductToCartICommand implements ICommand {
    private String idCart;
    private String idProduct;
}
