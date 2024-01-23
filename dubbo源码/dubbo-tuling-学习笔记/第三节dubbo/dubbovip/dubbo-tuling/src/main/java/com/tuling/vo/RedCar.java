package com.tuling.vo;


import com.tuling.UserService;
import com.tuling.interfaces.Car;
import org.apache.dubbo.common.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedCar implements Car {

    @Autowired
    private UserService userService;

    @Override
    public String getCarName(URL url ) {
        return "red";
    }

    @Override
    public String sayHell( ) {
        return null;
        /**
         *     @Override
         *     public String sayHell(Invocation invocation) {   Invocation如果这个对象里面有getUrl()方法，可以和上面的同样使用，
         *         return null;
         *     }
         */
    }
}
