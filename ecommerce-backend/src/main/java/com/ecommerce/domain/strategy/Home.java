package com.ecommerce.domain.strategy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("Home")
public class Home extends Category {

    private Integer day;
    private Integer from;
    private Integer to;
    private Double discount;

    public Home(Integer day,Integer from,Integer to,Double discount){
        this.day = day;
        this.from = from;
        this.to = to;
        this.discount = discount;
    }

    public Home() {

    }

    @Override
    public Double discount(Double price) {
        Map<String, Integer> dayAndTime = Utils.getDayAndTime();
        if(this.correctDayAndTime(dayAndTime)){
            return price * discount;
        } else{
            return price;
        }
    }

    @Override
    public Boolean correctDayAndTime(Map<String, Integer> dayAndTime) {
        return dayAndTime.get("day").equals(day) && Utils.between(dayAndTime.get("time"),from,to);
    }
}
