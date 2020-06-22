package com.evobank.shopping;

import com.evobank.architecture.application.BpmDelegate;
import com.evobank.architecture.application.CommandHandler;
import com.evobank.architecture.application.QueryHandler;
import com.evobank.architecture.domain.Factory;
import com.evobank.architecture.domain.bus.event.DomainEventSubscriber;
import com.evobank.architecture.domain.service.DomainService;
import com.evobank.architecture.infrastructure.Adapter;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.architecture.usecases.CaseOfUse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
		BpmDelegate.class,
		DomainEventSubscriber.class,
		InjectDependency.class,
		CommandHandler.class,
		QueryHandler.class,
		CaseOfUse.class,
		Adapter.class,
		DomainService.class,
		Factory.class
}))
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

}
