package com.evobank.shopping.submodules.shared.products.domain.exceptions;

import com.evobank.architecture.domain.exceptions.DomainException;

public class ProductNotFoundException extends DomainException {
    public ProductNotFoundException(String msn){
        super(msn);
    }
}
