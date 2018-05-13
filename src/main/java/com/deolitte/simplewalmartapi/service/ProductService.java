package com.deolitte.simplewalmartapi.service;

import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.model.SearchQueryDto;

public interface ProductService {

    SearchQueryDto getProducts();

    ProductDto getProductByItemId(long itemId);
}
