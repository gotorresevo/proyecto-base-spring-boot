package com.evobank.shopping.submodules.businessruletask.domain.vo;

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
public final class BusinessRuleTaskSeason implements IValueObject {
    private String value;

    public static BusinessRuleTaskSeason createFromCommand(String value) {
        return new BusinessRuleTaskSeason(value);
    }

    @Override
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
        throw new UnsupportedOperationException();
    }
}
