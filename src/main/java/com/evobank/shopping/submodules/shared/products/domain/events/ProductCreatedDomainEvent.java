package com.evobank.shopping.submodules.shared.products.domain.events;

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
public final class ProductCreatedDomainEvent extends DomainEvent {
    private final String id, name;

    public ProductCreatedDomainEvent(String id, String name) {
        super(id);
        this.name = name;
        this.id = id;
    }

    public ProductCreatedDomainEvent(String id, String eventId, String occurredOn, String name) {
        super(id, eventId, occurredOn);
        this.id = name;
        this.name = name;
    }


    @Override
    public String eventName() {
        return "product.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}
