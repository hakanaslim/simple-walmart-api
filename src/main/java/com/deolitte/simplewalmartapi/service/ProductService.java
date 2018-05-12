package com.deolitte.simplewalmartapi.service;

public interface ProductService {

    String getProducts();
    
    String getProductByItemId(long itemId);
}
