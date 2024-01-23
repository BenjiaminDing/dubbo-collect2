package com.tuling.vo;





//import com.tuling.Car;

import com.tuling.interfaces.Car;
import com.tuling.interfaces.Person;


public class BlackPerson implements Person {

    private Car car;   //  赋值的是Car的一个代理对象

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public Car getCar() {
        return car;
    }
}
