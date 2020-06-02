package com.evobank.shopping.submodules.carts.domain.exceptions;

import com.evobank.architecture.domain.exceptions.DomainException;

public class CartDomainException extends DomainException {
    public CartDomainException(String msn){
        super(msn);
    }
}
