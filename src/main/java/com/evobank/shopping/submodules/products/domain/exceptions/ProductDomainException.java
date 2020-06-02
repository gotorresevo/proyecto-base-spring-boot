package com.evobank.shopping.submodules.products.domain.exceptions;

import com.evobank.architecture.domain.exceptions.DomainException;

public class ProductDomainException extends DomainException {
    public ProductDomainException(String msn){
        super(msn);
    }
}
