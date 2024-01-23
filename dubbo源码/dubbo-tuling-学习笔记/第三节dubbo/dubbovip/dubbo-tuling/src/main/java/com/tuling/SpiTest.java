package com.tuling;


import com.tuling.interfaces.Car;
import org.apache.dubbo.common.extension.ExtensionLoader;




public class SpiTest {
    public static void main(String[] args) {

//        ServiceLoader<Car> cars = ServiceLoader.load(Car.class);
//        for (Car car : cars) {
//            System.out.println(car.getCarName(null));
//        }


//        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
//        Protocol protocol = extensionLoader.getExtension("http");
//        System.out.println(protocol);

        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);

        Car car = extensionLoader.getExtension("red111"); // 自动注入，AOP

//        System.out.println(car.getCarName());

//        ExtensionLoader<com.tuling.Person> extensionLoader = ExtensionLoader.getExtensionLoader(com.tuling.Person.class);
//        com.tuling.Person person = extensionLoader.getExtension("black");  // BlackPerson
//
//        URL url = new URL("x", "localhost", 8080);
//        url = url.addParameter("car", "red");
//
//        System.out.println(person.getCar().getCarName(url));  // 代理逻辑




//        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
//        URL url = new URL("http://", "localhost", 8080);
//        url = url.addParameter("cache", "test");
//        List<Filter> activateExtensions = extensionLoader.getActivateExtension(url, new String[]{"validation"}, CommonConstants.CONSUMER);
//        for (Filter activateExtension : activateExtensions) {
//            System.out.println(activateExtension);
//        }


//        ConcurrentHashSet set = new ConcurrentHashSet();
//        set.add("周瑜1");
//        set.add("周瑜2");
//        set.add("周瑜3");
//
//        System.out.println(set);
    }
}
