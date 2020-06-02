package com.evobank.architecture.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class DomainException extends RuntimeException {
    @Getter
    private List<RuntimeException> exceptions = new ArrayList<>();

    public DomainException(String msn){
        super(msn);
    }

    public void add(RuntimeException runtimeException){
        exceptions.add(runtimeException);
    }


}
