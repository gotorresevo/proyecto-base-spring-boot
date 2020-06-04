package com.evobank.architecture.domain.bus.event;

import java.util.List;

public interface IEventBus {
    void publish(final List<DomainEvent> events);
}
