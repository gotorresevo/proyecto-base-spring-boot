package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductIdException;
import com.evobank.shopping.submodules.products.domain.service.ProductsValidator;
import com.evobank.shopping.submodules.products.domain.vo.enums.Process;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductId implements IValueObject {
    private String value;
    private Process process;

    public static ProductId createFromCommand(String value) {
        return new ProductId(value, Process.CREATE);
    }

    public static ProductId updateFromCommand(String value) {
        return new ProductId(value, Process.UPDATE);
    }

    @Override
    public void valid(IValidator finder) {
        ProductsValidator productsValidator = (ProductsValidator) finder;
        ensureSetValueIfIsNull(getValue());
        ensureIdCorrect(getValue());
        if (Process.CREATE.equals(process)) {
            ensureThatTheProductIdDoesNotExist(productsValidator);
        }
    }

    private void ensureSetValueIfIsNull(String value) {
        if (null == value) {
            this.value = UUID.randomUUID().toString();
        }
    }

    private void ensureIdCorrect(String value) {
        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new ProductIdException(String.format("El formato del Id '%s' no es valido", getValue()));
        }
    }

    private void ensureThatTheProductIdDoesNotExist(ProductsValidator productsValidator) {
        if (productsValidator.isThereAProductWithTheSameId(this))
            throw new ProductIdException(String.format("El Id '%s' dado al producto ya existe en otro producto", getValue()));
    }
}
