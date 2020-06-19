package com.evobank.shopping.submodules.products.domain.vo;

import com.evobank.architecture.domain.service.IValidator;
import com.evobank.architecture.domain.vo.IValueObject;
import com.evobank.shopping.submodules.products.domain.exceptions.ProductIdException;
import com.evobank.shopping.submodules.products.domain.vo.enums.Process;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
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
    public void valid(IValidator validator, List<IValueObject> valueObjects) {
        ensureSetValueIfIsNull(getValue());
        ensureIdCorrect(getValue());
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
}
