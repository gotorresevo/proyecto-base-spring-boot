package com.evobank.shopping.submodules.products.domain.exceptions;

public final class ProductStockException extends RuntimeException {
    public ProductStockException(String msn) {
        super(msn);
    }
}
