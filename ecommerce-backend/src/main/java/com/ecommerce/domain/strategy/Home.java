package com.ecommerce.domain.strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@DiscriminatorValue("Home")
public class Home extends Category {

    public Home(Integer day, Integer timeFrom,Integer timeTo) {
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public Home() {

    }

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
        return dayAndTime.get("day").equals(day) && Utils.between(dayAndTime.get("time"),timeFrom,timeTo);
    }
}
