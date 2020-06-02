package com.evobank.shopping.submodules.shared.carts.domain.events;

import com.evobank.architecture.domain.bus.event.DomainEvent;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public final class ProductAggregateToCartDomainEvent extends DomainEvent {
    private final String idCart;
    private final String idProduct;

    public ProductAggregateToCartDomainEvent(String idCart, String idProduct) {
        super(idProduct);
        this.idProduct = idProduct;
        this.idCart = idCart;
    }

    public ProductAggregateToCartDomainEvent(String idProduct, String eventId, String occurredOn, String idCart) {
        super(idProduct, eventId, occurredOn);
        this.idCart = idCart;
        this.idProduct = idProduct;
    }


    @Override
    public String eventName() {
        return "product.aggregated";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("idCart", idCart);
            put("idProduct", idProduct);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}
