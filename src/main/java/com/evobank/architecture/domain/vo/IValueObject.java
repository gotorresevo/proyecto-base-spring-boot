package com.evobank.architecture.domain.vo;

import com.evobank.architecture.domain.service.IValidator;

public interface IValueObject {

    void valid(IValidator searcher);
}
