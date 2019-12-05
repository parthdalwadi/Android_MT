package com.example.parth_c0766346_mt;

import java.io.Serializable;

public class CarInfo implements Serializable {

    String carName, dailyRent, no_of_days, s_amount, s_Total, options, d_age;

    public CarInfo(String carName, String dailyRent, String no_of_days, String s_amount, String s_Total, String options, String d_age) {
        this.carName = carName;
        this.dailyRent = dailyRent;
        this.no_of_days = no_of_days;
        this.s_amount = s_amount;
        this.s_Total = s_Total;
        this.options = options;
        this.d_age = d_age;
    }
}
