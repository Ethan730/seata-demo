package com.ethan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private int id;
    private int number;
    private int status;
}
