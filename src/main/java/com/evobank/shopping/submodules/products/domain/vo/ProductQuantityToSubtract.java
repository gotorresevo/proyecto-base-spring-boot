package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductQuantityToSubtractException;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductQuantityToSubtract implements IValueObject {

    private Integer value;

    public static ProductQuantityToSubtract createFromCommand(Integer value) {
        return new ProductQuantityToSubtract(value);
    }
    public static ProductQuantityToSubtract updateFromCommand(Integer value) {
        return new ProductQuantityToSubtract(value);
    }

    private void ensureNull(Integer value) {
        if (null == value)
            throw new ProductQuantityToSubtractException("Para restar la cantidad del producto en stock debe enviar una cantidad valida");
    }

    private void ensureEmpty(Integer value) {
        if (0 > value)
            throw new ProductQuantityToSubtractException("Para restar la cantidad del producto en stock debe enviar una cantidad mayor a 0");
    }


    @Override
    public void valid(IValidator searcher, List<IValueObject> valueObjects) {
        ensureNull(getValue());
        ensureEmpty(getValue());
    }
}
