//package com.tuling;

package com.tuling.interfaces;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("red")
public interface Car {

    @Adaptive//??
    String getCarName(URL url);

    String sayHell();


}
