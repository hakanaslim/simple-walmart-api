package com.deolitte.simplewalmartapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductImageDto {
    String thumbnailImage;
    String mediumImage;
    String largeImage;
    String entityType;
    
}
