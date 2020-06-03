package com.evobank.shopping.submodules.shared.carts.domain.events;

import com.evobank.architecture.domain.bus.event.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductAggregateToCartDomainEvent extends DomainEvent {
    private final String idCart;
    private final String idProduct;

    public ProductAggregateToCartDomainEvent(String idCart, String idProduct) {
        super(idProduct);
        this.idProduct = idProduct;
        this.idCart = idCart;
    }


    @Override
    public String eventName() {
        return "product.aggregated";
    }

    @Override
    public Map<String, Serializable> toPrimitives() {
        Map<String, Serializable> map = new HashMap<>();
        map.put("idCart", idCart);
        map.put("idProduct", idProduct);
        return map;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, Map<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}
