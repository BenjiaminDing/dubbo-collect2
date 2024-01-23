```


```



```
1---RPC概述
RPC*****是远程过程调用（Remote Procedure Call）。 RPC 的主要功能目标是让构建分布式计算（应用）更容易，在提供强大的远程调用能力时不损失本地调用的语义简洁性。为实现该目标，RPC 框架需提供一种透明调用机制，让使用者不必显式地区分本地调用和远程调用。



2--有哪些RPC框架


------
作者：程序猿不脱发2
链接：https://www.jianshu.com/p/56659cf4c37c
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



```
注意 ：我们这里说的 RPC 框架指的是：可以让客户端直接调用服务端方法就像调用本地方法一样简单的框架，比如我前面介绍的 Dubbo、Motan、gRPC 这些。 如果需要和 HTTP 协议打交道，解析和封装 HTTP 请求和响应。这类框架并不能算是“RPC 框架”，比如 Feign。


服务提供端 Server 向注册中心注册服务，服务消费者 Client 通过注册中心拿到服务相关信息，然后再通过网络请求服务提供端 Server。

作为 RPC 框架领域的佼佼者[Dubbo](https://github.com/apache/dubbo)的架构如下图所示,和我们上面画的大体也是差不多的。


一般情况下， RPC 框架不仅要提供服务发现功能，还要提供负载均衡、容错等功能，这样的 RPC 框架才算真正合格的。
```





把协议封装的技术是socket技术

Dubbo基于TCP协议建立通讯

spring的restTemplate 是基于http协议



rpc--实现rpc的方式很多（甚至可以是一个MQ实现 ）--rpc一种标准



```
WebService服务端通过一个文件（WSDL）来说明自己家里有啥服务可以对外调用，服务是什么（服务中有哪些方法，方法接受 的参数是什么，返回值是什么），服务的网络地址用哪个url地址表示，服务通过什么方式来调用。WSDL(Web Services Description Language)是一个基于XML的语言，用于描述Web Service及其函数、参数和返回值。它是WebService客户端和服务器端都能理解的标准格式。因为是基于XML的，所以WSDL既是机器可阅读的，又是人可阅读的，这将是一个很大的好处。一些最新的开发工具既能根据你的 Web service生成WSDL文档，又能导入WSDL文档，生成调用相应WebService的代理类代码。WSDL 文件保存在Web服务器上，通过一个url地址就可以访问到它。客户端要调用一个WebService服务之前，要知道该服务的WSDL文件的地址。 WebService服务提供商可以通过两种方式来暴露它的WSDL文件地址：1.注册到UDDI服务器，以便被人查找；2.直接告诉给客户端调用者。

作者：伤她心我是万万不能
链接：https://www.jianshu.com/p/5bb727b434e6
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```





```
socket 基于TCP协议  传输层
restTenmplate基于http 应用层
rest协议也是dubbo支持的协议，其实test协议底层还是http协议（估计是数据结构有略微变化）

dubbo支持多种协议
默认提供dubbo协议，就是一种独特的数据格式 数据格式netty
http协议--也就是自己独特的数据格式
```

![image-20220815195106180](D:/音乐图片/typora图片/image-20220815195106180.png)











## JAVA的SPI有应用再数据库连接方面（例如jdbc去连接数据库，涉及多种数据源，mysql oracle ，如何解决这个问题就是使用ServiceLoader类）

但是dubbo在此基础上进行优化 就开发出dubbo的SPI机制吗，





```
类加载器分类
boot--jre/lib
ext--jre/ext/lib
app--classpath
```

```
对象工厂的使用，
```



```
dubbo生成代理对象的方式是 动态编译complie，没有使用jdk的动态代理方式生成代理对象

了解循环依赖情景
```

