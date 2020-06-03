package com.evobank.shopping.submodules.carts.domain.exceptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(String msn){
        super(msn);
    }
}
