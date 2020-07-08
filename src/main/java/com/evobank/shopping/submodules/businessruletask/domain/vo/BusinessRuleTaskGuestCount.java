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
public final class BusinessRuleTaskGuestCount implements IValueObject {
    private Integer value;

    public static BusinessRuleTaskGuestCount createFromCommand(Integer value) {
        return new BusinessRuleTaskGuestCount(value);
    }

    @Override
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
        throw new UnsupportedOperationException();
    }
}
