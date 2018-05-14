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
public class ProductDto {
    Long itemId;
    Long parentItemId;
    String name;
    Double msrp;
    Double salePrice;
    String categoryPath;
    String shortDescription;
    String longDescription;
    String thumbnailImage;
    String mediumImage;
    String largeImage;
    String productTrackingUrl;
    Double standardShipRate;
    Boolean marketplace;
    String productUrl;
    String categoryNode;
    String stock;
    Collection<ProductImageDto> imageEntities;
    
}
