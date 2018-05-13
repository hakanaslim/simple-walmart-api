package com.deolitte.simplewalmartapi.controller;

import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.model.SearchQueryDto;
import com.deolitte.simplewalmartapi.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product", method = RequestMethod.OPTIONS)
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchQueryDto> findProducts() {
        SearchQueryDto products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @ResponseBody
    @GetMapping(value = "/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductByItem(@PathVariable("item_id") long itemId) {
        return ResponseEntity.ok(productService.getProductByItemId(itemId));
    }
}

