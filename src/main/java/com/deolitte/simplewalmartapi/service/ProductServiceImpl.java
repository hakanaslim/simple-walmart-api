package com.deolitte.simplewalmartapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${walmart.api-key}")
    public String walmartApiKey;

    @Value("${walmart.api-format}")
    public String walmartApiFormat;

    @Value("${walmart.url}")
    public String walmartURL;

    @Override
    public String getProducts() {

        ResponseEntity<String> responseEntity = new RestTemplateBuilder().build().getForEntity(
                new StringBuilder()
                        .append(walmartURL).append("/search")
                        .append("?apiKey=").append(walmartApiKey)
                        .append("&format=").append(walmartApiFormat)
                        .append("&query=books")
                        .toString()
                , String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();

        return "";
    }

    @Override
    public String getProductByItemId(long itemId) {

        ResponseEntity<String> responseEntity = new RestTemplateBuilder().build().getForEntity(
                new StringBuilder()
                        .append(walmartURL).append("/items")
                        .append("/").append(itemId)
                        .append("?apiKey=").append(walmartApiKey)
                        .append("&format=").append(walmartApiFormat)
                        .toString()
                , String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();

        return "";
    }
}
