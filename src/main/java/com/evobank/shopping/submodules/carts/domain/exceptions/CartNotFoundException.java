package com.evobank.shopping.submodules.carts.domain.exceptions;

import com.evobank.architecture.domain.exceptions.DomainException;

public class CartNotFoundException extends DomainException {
    public CartNotFoundException(String msn){
        super(msn);
    }
}
