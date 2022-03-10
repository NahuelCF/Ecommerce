package com.ecommerce.domain.strategy;

import javax.persistence.*;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CategoryType")
public abstract class Category {
    @Id
    @GeneratedValue
    private Long id;

    Integer day;

    Integer timeFrom;

    Integer timeTo;

    public Double discount(Double price){
        return price;
    };
    Boolean correctDayAndTime(Map<String,Integer> dayAndTime){
        return false;
    };
}