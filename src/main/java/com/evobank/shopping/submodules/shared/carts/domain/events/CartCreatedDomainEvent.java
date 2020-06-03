package com.evobank.shopping.submodules.shared.carts.domain.events;

import com.evobank.architecture.domain.bus.event.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode(callSuper = false)
public final class CartCreatedDomainEvent extends DomainEvent {
    private final String id;

    public CartCreatedDomainEvent(String id) {
        super(id);
        this.id = id;
    }

    @Override
    public String eventName() {
        return "product.created";
    }

    @Override
    public Map<String, Serializable> toPrimitives() {
        Map<String, Serializable> map = new HashMap<>();
        map.put("id", id);
        return map;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, Map<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}
