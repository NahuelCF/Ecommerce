package com.ecommerce.domain.strategy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.Map;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Home.class, name = "home")
})
public abstract class Category {
    @Id
    @GeneratedValue
    public Long id;

    Integer day;

    Integer timeFrom;

    Integer timeTo;

    public Double discount(Double price){
        return price;
    }
    Boolean correctDayAndTime(Map<String,Integer> dayAndTime){
        return false;
    }
}