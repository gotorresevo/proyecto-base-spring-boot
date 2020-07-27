package com.evobank.shopping.submodules.subprocess.callactivity.vo;

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
public final class CallActivityVar1 implements IValueObject {
    private String value;

    public static CallActivityVar1 createFromCommand(String value) {
        return new CallActivityVar1(value);
    }

    @Override
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
        throw new UnsupportedOperationException();
    }
}
