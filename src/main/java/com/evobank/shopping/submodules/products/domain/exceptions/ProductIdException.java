package com.evobank.shopping.submodules.products.domain.exceptions;

public final class ProductIdException extends ProductDomainException {
    public ProductIdException(String msn) {
        super(msn);
    }
}
