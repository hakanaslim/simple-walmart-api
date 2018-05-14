package com.deolitte.simplewalmartapi.service;

import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.model.SearchQueryDto;
import com.deolitte.simplewalmartapi.model.filter.ProductFilter;

public interface ProductService {

    SearchQueryDto findProducts(ProductFilter productFilter);

    ProductDto getProductByItemId(long itemId);
}
