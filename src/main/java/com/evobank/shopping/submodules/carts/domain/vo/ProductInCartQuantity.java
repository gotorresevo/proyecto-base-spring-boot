package com.evobank.shopping.submodules.carts.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.carts.domain.exceptions.CartIdException;
import com.evobank.shopping.submodules.carts.domain.service.CartValidator;
import com.evobank.shopping.submodules.shared.products.domain.exceptions.ProductNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
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

    }
}
