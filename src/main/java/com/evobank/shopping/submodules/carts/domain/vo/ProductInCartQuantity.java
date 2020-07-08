package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public final class ProductInCartQuantity implements IValueObject {
    private Integer value;

    public static ProductInCartQuantity createFromCommand(Integer value) {
        return new ProductInCartQuantity(value);
    }

    @Override
    public void valid(IValidator finder, List<IValueObject> valueObjects) {
        isThereQuantityInStock(getValue(), finder);
    }

    private void isThereQuantityInStock(Integer value, IValidator finder) {
        log.debug("for Implement");
    }
}
