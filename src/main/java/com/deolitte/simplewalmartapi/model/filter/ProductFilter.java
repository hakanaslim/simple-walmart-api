package com.deolitte.simplewalmartapi.model.filter;

import com.deolitte.simplewalmartapi.model.ProductDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductFilter extends ProductDto {
    String query;
    Integer startRange;
    Integer endRange;
}
