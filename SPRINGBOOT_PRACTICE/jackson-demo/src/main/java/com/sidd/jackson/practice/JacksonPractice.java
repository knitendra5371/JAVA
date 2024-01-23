package com.sidd.jackson.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

class Laptop{
    String brand;
    String model;

    public Laptop() {
    }

    public Laptop(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

public class JacksonPractice {
    public static void main(String[] args) {
       /*
       * converting json String data in java object here
       * */
        System.out.println("\nconverting json String data in java object\n");
        String jsonData = "{\"brand\":\"abc\",\"model\":\"xyz\"}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            Laptop laptop = mapper.readValue(jsonData, Laptop.class);
            System.out.println(laptop);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        /*
        * converting json array String data in java objects here
        * */
        System.out.println("\nconverting json array String data in java objects in array\n\n");
        String jsonArrayData = "[{\"brand\":\"abc\",\"model\":\"xyz\"},"
                +"{\"brand\":\"pqr\",\"model\":\"jhk\"}]";

        try {
            Laptop[] laptops = mapper.readValue(jsonArrayData, Laptop[].class);
            for(Laptop laptop: laptops){
                System.out.println(laptop);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        /*
         * converting json array String data in java objects in list here
         * */

        System.out.println("\nconverting json array String data in java objects in list\n");
        try {
            List<Laptop> laptopList = mapper.readValue(jsonArrayData, new TypeReference<List<Laptop>>(){});
            laptopList.forEach(laptop -> System.out.println(laptop));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        /*
         * converting json array String data in java objects in map here
         * */

        System.out.println("\nconverting json String data in java objects in map\n");
        try {
            Map<String, String> map = mapper.readValue(jsonData, new TypeReference<Map<String, String>>() {});

            map.keySet().forEach(key->{
                System.out.println("key: "+key+" , value: "+map.get(key));
            });

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
