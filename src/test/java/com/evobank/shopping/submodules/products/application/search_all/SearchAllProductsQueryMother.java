package com.evobank.shopping.submodules.products.application.search_all;

public final class SearchAllProductsQueryMother {
    public static SearchAllProductsIQuery create() {
        return new SearchAllProductsIQuery();
    }

    public static SearchAllProductsIQuery random() {
        return create();
    }
}
