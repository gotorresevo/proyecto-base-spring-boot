package com.evobank.shopping.submodules.products.domain.exceptions;

public final class ProductIdException extends RuntimeException {
    public ProductIdException(String msn) {
        super(msn);
    }
}
