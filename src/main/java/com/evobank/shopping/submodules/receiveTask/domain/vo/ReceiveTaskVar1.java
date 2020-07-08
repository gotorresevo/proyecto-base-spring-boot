package com.evobank.shopping.submodules.receiveTask.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class ReceiveTaskVar1 implements IValueObject {
    private String value;

    public static ReceiveTaskVar1 createFromCommand(String value) {
        return new ReceiveTaskVar1(value);
    }

    @Override
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
    }
}
