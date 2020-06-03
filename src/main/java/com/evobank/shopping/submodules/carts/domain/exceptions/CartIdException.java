package com.evobank.shopping.submodules.carts.domain.exceptions;

public final class CartIdException extends RuntimeException {
    public CartIdException(String msn) {
        super(msn);
    }
}
