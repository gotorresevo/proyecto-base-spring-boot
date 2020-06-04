package com.evobank.shopping.submodules.products.application.search_all;

import com.evobank.shopping.submodules.products.ProductsModuleUnitTestCase;
import com.evobank.shopping.submodules.products.usecases.ProductsSearcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchAllProductsIIQueryHandlerTest extends ProductsModuleUnitTestCase {

    private SearchAllProductsQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new SearchAllProductsQueryHandler(new ProductsSearcher(repository));
    }

    @Test
    void find_all_products() {
        SearchAllProductsQuery query = SearchAllProductsQueryMother.random();
        handler.handle(query);
        shouldHaveSearched();
    }
}