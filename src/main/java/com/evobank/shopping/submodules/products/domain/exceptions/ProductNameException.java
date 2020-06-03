package com.evobank.shopping.submodules.products.domain.exceptions;

public final class ProductNameException extends RuntimeException {
    public ProductNameException(String msn) {
        super(msn);
    }
}
