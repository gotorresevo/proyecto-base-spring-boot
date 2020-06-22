package com.evobank.shopping.submodules.products.domain.exceptions;

public final class ProductQuantityToSubtractException extends RuntimeException {
    public ProductQuantityToSubtractException(String msn) {
        super(msn);
    }
}
