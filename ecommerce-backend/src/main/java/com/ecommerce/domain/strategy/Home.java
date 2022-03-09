package com.ecommerce.domain.strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@DiscriminatorValue("Home")
public class Home extends Category {
    @Override
    public Double discount(Double price) {
        Map<String, Integer> dayAndTime = Utils.getDayAndTime();
        if(this.correctDayAndTime(dayAndTime)){
            return price * 0.8;
        } else{
            return price;
        }
    }

    @Override
    public Boolean correctDayAndTime(Map<String, Integer> dayAndTime) {
        //TODO: hacer el dia y hora un atributo
        System.out.print("HOME");
        System.out.print("DAY: " + dayAndTime.get("day").equals(2));
        System.out.print("TIME: " + Utils.between(dayAndTime.get("time"),20,22));
        return dayAndTime.get("day").equals(2) && Utils.between(dayAndTime.get("time"),20,22);
    }
}
