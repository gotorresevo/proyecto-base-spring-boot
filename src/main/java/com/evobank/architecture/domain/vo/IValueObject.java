package com.evobank.architecture.domain.vo;

import com.evobank.architecture.domain.service.IValidator;

import java.util.List;

public interface IValueObject {

    void valid(IValidator validator, List<IValueObject> valueObjects);
}
