package com.deolitte.simplewalmartapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchQueryDto {
    String query;
    String sort;
    String responseGroup;
    Long totalResults;
    Long start;
    Long numItems;
    Collection<ProductDto> items;
}
