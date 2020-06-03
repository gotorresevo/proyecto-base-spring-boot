package com.evobank.shopping.submodules.shared.products.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String msn){
        super(msn);
    }
}
