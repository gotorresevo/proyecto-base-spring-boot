package com.evobank.shopping.submodules.products.application.search_all;

import com.evobank.shopping.submodules.products.ProductsModuleUnitTestCase;
import com.evobank.shopping.submodules.products.usecases.ProductsSearcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchAllProductsIIQueryHandlerTest extends ProductsModuleUnitTestCase {

    private SearchAllProductsIQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new SearchAllProductsIQueryHandler(new ProductsSearcher(repository));
    }

    @Test
    void find_all_products() {
        SearchAllProductsIQuery query = SearchAllProductsQueryMother.random();
        handler.handle(query);
        shouldHaveSearched();
    }
}