::flags

@DubboService--2.2.7之后是替换之前的@Service

![图01](D:\音乐图片\typora图片/image-20220914215652894.png)

![图02](D:\音乐图片\typora图片/image-20220914215613437.png)

上图的注解@EnableDubbo的注解类上面是有

```
@EnableDubboConfig  --处理properties配置文件的
@DubboComponentScan --扫描使用注解的类的

```



```
01 启动spring  扫描哪些类上有@DubboService注解
@Service的注解的属性 有许多version,timeout等等，使用@Service注解可以创建一个ServiceBean对象，同时将注解的属性赋值给ServiceBean对象
@Service注解添加到一个类上，dubbo会生成两个对象，Dubbo-Servicebean和spring-bean
，多个接口会产生多个Dubbo-ServiceBean，type一样，name不一样是可以共存的
```

Servicebean里面有一个export（） 方法

```java
    @Override
    public void export() {
        super.export();
        // Publish ServiceBeanExportedEvent
        // Spring启动完发布ContextRefreshedEvent事件--->服务导出--->发布ServiceBeanExportedEvent
        // 程序员可以通过Spring中的ApplicationListener来监听服务导出是否完成
        publishExportEvent();
    }
         super.export();   这个方法就是用于服务导出的
                     publishExportEvent();// 发布接口完成服务的注册
```

```
ServiceBean一个属性是Ref--指向DemoServiceImpl（spring-Bean），也就是DemoService的实现类接口是 DemoServiceImpl
```

```
    /**   支持的协议
    AbstractServiceConfig---的属性
    
     * The protocol list the service will export with  
     */
    protected List<ProtocolConfig> protocols;   
    
AbstractInterfaceConfig--类的属性    
        /**
     * Service monitor
     */
    protected MonitorConfig monitor;  注册中心
```



```
所哟ServiceBean十分重要，我们需要将 使用@DubboService注解的类，使用注解声明的属性（类似version,timeout)的  赋值给ServiceBean，还需要将application.properties的配置的参数值 赋值到ServiceBean里面
```

```
    @PropertySource("classpath:/spring/dubbo-provider.properties")   // PropertySource是spring的注解  Enviroment
    在spring这行注解会把读取的配置文件信息放入spring Envirment对象里面，dubbo去取出来 然后创建许多对象
    ---
    dubbo.application.name=dubbo-demo-provider1-application
dubbo.application.logger=log4j  这两行生成 ApplicationConfig的对象
```



通过referenceBean对象   get()得到一个  代理对象， 相当于使用引入的dubbo服务



::flags:     笔记连接

[第四节: Spring与Dubbo整合原理与源码分析 · 语雀 (yuque.com)](https://www.yuque.com/books/share/f2394ae6-381b-4f44-819e-c231b39c1497/anzy3o):

访问密码kyys