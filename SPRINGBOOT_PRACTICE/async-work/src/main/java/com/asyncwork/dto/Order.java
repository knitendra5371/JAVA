package com.asyncwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String trackingId;
    private int productId;
    private String name;
    private String productType;
    private int qty;
    private int price;
}
