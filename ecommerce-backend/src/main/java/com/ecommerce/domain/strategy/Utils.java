package com.ecommerce.domain.strategy;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Utils {

    static Map<String,Integer> getDayAndTime(){
        Map<String,Integer> dayAndTime = new HashMap<>();
        Date now = new Date();
        dayAndTime.put("day",now.getDay());
        dayAndTime.put("time",now.getHours());
        return dayAndTime;
    }

    static Boolean between(Integer number, Integer from, Integer to){
        return number <= to && number >= from;
    }

}
