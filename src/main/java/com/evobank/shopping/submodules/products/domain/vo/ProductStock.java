package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductStockException;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductStock implements IValueObject {

    private Integer value;

    public static ProductStock createFromCommand(Integer value) {
        return new ProductStock(value);
    }
    public static ProductStock updateFromCommand(Integer value) {
        return new ProductStock(value);
    }

    private void ensureNull(Integer value) {
        if (null == value)
            throw new ProductStockException("Para crear el producto debe enviar el stock");
    }

    private void ensureEmpty(Integer value) {
        if (0 > value)
            throw new ProductStockException("El stock del producto no puede ser menor a 0");
    }


    @Override
    public void valid(IValidator searcher, List<IValueObject> valueObjects) {
        ensureNull(getValue());
        ensureEmpty(getValue());
    }

    public ProductStock subtract(ProductQuantityToSubtract quantityToSubtract) {
        return new ProductStock(getValue()-quantityToSubtract.getValue());
    }
}
