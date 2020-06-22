package com.evobank.shopping.submodules.shared.products.domain.events;

import com.evobank.architecture.domain.bus.event.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class ProductStockSubtractedDomainEvent extends DomainEvent {
    private final String id;
    private final String name;

    public ProductStockSubtractedDomainEvent(String id, String name) {
        super(id);
        this.name = name;
        this.id = id;
    }


    @Override
    public String eventName() {
        return "product.stock.subtracted";
    }

    @Override
    public Map<String, Serializable> toPrimitives() {
        Map map = new HashMap();
        map.put("name", name);
        return map;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, Map<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}
