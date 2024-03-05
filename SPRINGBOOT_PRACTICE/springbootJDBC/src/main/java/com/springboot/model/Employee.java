package com.springboot.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private int id;
    private String name;
    private int salary;
}
