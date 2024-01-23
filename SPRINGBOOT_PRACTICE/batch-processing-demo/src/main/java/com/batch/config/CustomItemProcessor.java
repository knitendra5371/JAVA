package com.batch.config;

import com.batch.models.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomItemProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product item) throws Exception {

        try {
            int discountPer = Integer.parseInt(item.getDiscount());
            System.out.println(item);
            double originalPrice = Double.parseDouble(item.getPrice());
            double discount = (discountPer / 100.0) * originalPrice;
            double finalPrice = originalPrice - discount;
            item.setDiscountedPrice(String.valueOf(finalPrice));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("exception===>>"+item);
        }
        return item;
    }
}
