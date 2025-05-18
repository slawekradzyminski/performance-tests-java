package com.awesome.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductDto {

    private String name;
    private double price;
    private int stockQuantity;
    private String category;
    private String imageUrl;

}
