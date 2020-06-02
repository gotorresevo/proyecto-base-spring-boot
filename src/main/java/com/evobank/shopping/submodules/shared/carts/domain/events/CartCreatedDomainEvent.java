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
public final class CartCreatedDomainEvent extends DomainEvent {
    private final String id;

    public CartCreatedDomainEvent(String id) {
        super(id);
        this.id = id;
    }

    public CartCreatedDomainEvent(String id, String eventId, String occurredOn) {
        super(id, eventId, occurredOn);
        this.id = id;
    }


    @Override
    public String eventName() {
        return "product.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}
