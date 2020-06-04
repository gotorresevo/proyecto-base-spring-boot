package com.evobank.shopping.submodules.products.application.search_all;

import com.evobank.architecture.application.QueryHandler;
import com.evobank.architecture.domain.bus.query.IQueryHandler;
import com.evobank.architecture.infrastructure.InjectDependency;
import com.evobank.shopping.submodules.products.application.ProductResponse;
import com.evobank.shopping.submodules.products.application.ProductsResponse;
import com.evobank.shopping.submodules.products.usecases.ProductsSearcher;
import lombok.AllArgsConstructor;
import java.util.Optional;
import java.util.stream.Collectors;

@QueryHandler
@AllArgsConstructor(onConstructor_= @InjectDependency)
public final class SearchAllProductsQueryHandler implements IQueryHandler<SearchAllProductsQuery, ProductsResponse> {
    private final ProductsSearcher searcher;
    @Override
    public Optional<ProductsResponse> handle(SearchAllProductsQuery query) {
        return Optional.of(new ProductsResponse(searcher.search()
                .map(product -> new ProductResponse(product.getId().getValue(), product.getName().getValue()))
                .collect(Collectors.toList())));
    }
}
