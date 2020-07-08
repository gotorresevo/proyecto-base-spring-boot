package com.evobank.shopping.submodules.userTask.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductIdException;
import com.evobank.shopping.submodules.products.domain.vo.enums.Process;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class UserTaskVar1 implements IValueObject {
    private String value;

    public static UserTaskVar1 createFromCommand(String value) {
        return new UserTaskVar1(value);
    }

    @Override
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
    }
}
