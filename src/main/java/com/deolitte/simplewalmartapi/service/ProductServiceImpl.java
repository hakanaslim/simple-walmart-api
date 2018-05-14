package com.deolitte.simplewalmartapi.service;

import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.model.SearchQueryDto;
import com.deolitte.simplewalmartapi.model.filter.ProductFilter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public SearchQueryDto findProducts(ProductFilter productFilter) {

        StringBuilder query = new StringBuilder()
                .append(walmartURL).append("/search")
                .append("?apiKey=").append(walmartApiKey)
                .append("&format=").append(walmartApiFormat);

        if (productFilter != null) {

            if (!StringUtils.isEmpty(productFilter.getQuery()))
                query.append("&query=" + productFilter.getQuery());
            else
                query.append("&query=books");

            if ((productFilter.getStartRange() != null && productFilter.getStartRange() > 0) ||
                    (productFilter.getEndRange() != null && productFilter.getEndRange() > 0)
                    ) {

                query.append("&facet=on");
                query.append("&facet.range=start:[" + productFilter.getStartRange() + " TO " + productFilter.getStartRange() + "]");
            }

        } else
            query.append("&query=books");

        ResponseEntity<SearchQueryDto> responseEntity = new RestTemplateBuilder().build().getForEntity(
                query.toString()
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
