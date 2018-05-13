package com.deolitte.simplewalmartapi.service;

import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.model.SearchQueryDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Setter
public class ProductServiceImpl implements ProductService {

    @Value("${walmart.api-key}")
    public String walmartApiKey;

    @Value("${walmart.api-format}")
    public String walmartApiFormat;

    @Value("${walmart.url}")
    public String walmartURL;

    @Override
    public SearchQueryDto getProducts() {

        ResponseEntity<SearchQueryDto> responseEntity = new RestTemplateBuilder().build().getForEntity(
                new StringBuilder()
                        .append(walmartURL).append("/search")
                        .append("?apiKey=").append(walmartApiKey)
                        .append("&format=").append(walmartApiFormat)
                        .append("&query=books")
                        .toString()
                , SearchQueryDto.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();

        return null;
    }

    @Override
    public ProductDto getProductByItemId(long itemId) {

        ResponseEntity<ProductDto> responseEntity = new RestTemplateBuilder().build().getForEntity(
                new StringBuilder()
                        .append(walmartURL).append("/items")
                        .append("/").append(itemId)
                        .append("?apiKey=").append(walmartApiKey)
                        .append("&format=").append(walmartApiFormat)
                        .toString()
                , ProductDto.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();

        return null;
    }
}
