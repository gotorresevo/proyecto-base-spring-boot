package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductNameException;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.enums.Process;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductName implements IValueObject {

    private String value;
    private Process process;

    public static ProductName createFromCommand(String value) {
        return new ProductName(value, Process.CREATE);
    }

    public static ProductName updateFromCommand(String value) {
        return new ProductName(value, Process.UPDATE);
    }

    private void ensureNotStartWithNumbers(String value) {
        IntStream.range(0, 9).filter(number -> value.startsWith(String.valueOf(number))).findFirst()
                .ifPresent(number -> {
                    throw new ProductNameException("El nombre del producto no puede inciar con un numero");
                });
    }

    private void ensureNull(String value) {
        if (null == value)
            throw new ProductNameException("Para crear el producto debe enviar un nombre");
    }

    private void ensureEmpty(String value) {
        if (value.isEmpty())
            throw new ProductNameException("El nombre del producto no puede ser vacio");
    }

    private void ensureThatTheProductNameDoesNotExist(ProductsValidator fundsSearcher) {
        if (fundsSearcher.isThereAProductWithTheSameName(this) && Process.CREATE.equals(process))
            throw new ProductNameException(String.format("El nombre '%s' dado al producto ya existe en otro producto", getValue()));
    }


    @Override
    public void valid(IValidator searcher, List<IValueObject> valueObjects) {
        ProductsValidator fundsSearcher = (ProductsValidator) searcher;
        ensureNull(getValue());
        ensureEmpty(getValue());
        ensureNotStartWithNumbers(getValue());
        ensureThatTheProductNameDoesNotExist(fundsSearcher);
    }
}
