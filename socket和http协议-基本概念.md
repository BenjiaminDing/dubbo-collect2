::bullettrain_front:::flags:  [socket技术详解（看清socket编程） - 枫飞飞 - 博客园 (cnblogs.com)](https://www.cnblogs.com/fengff/p/10984251.html)



个人认为 rpc的发送过程还是基于网路通讯的方式，还是需要使用socket,所以socket是 网路通讯的基础；

最基础的方式  是       基于传统的 **BIO** 的方式 **Socket** 进行网络传输，然后利用 **JDK 自带的序列化机制** 来实现这个 RPC 框架的

 现在大部分公司都使用    NIO    **替代 BIO 实现网络传输；**



传统的BIO使用socket原始模式  ：：：下图

![img](D:/音乐图片/typora图片/aHR0cHM6Ly9naXRlZS5jb20vU25haWxDbGltYi9uZXR0eS1wcmFjdGljYWwtdHV0b3JpYWwvcmF3L21hc3Rlci9waWN0dXJlcy9zb2NrZXQtbmV0d29yay1jb21tdW5pY2F0aW9uLXByb2Nlc3MucG5n)



2012年10月19日  **为了解决上述的问题，Java 1.4 中引入了 NIO ，一种同步非阻塞的 I/O 模型。**

```
Netty 实际上就基于 Java NIO 技术封装完善之后得到一个高性能框架，熟悉 NIO 的基本概念对于学习和更好地理解 Netty 还是很有必要的！

初识 NIO
NIO 是一种同步非阻塞的 I/O 模型，在 Java 1.4 中引入了 NIO 框架，对应 java.nio 包，提供了 Channel , Selector，Buffer 等抽象。
————————————————
版权声明：本文为CSDN博主「JavaGuide」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_34337272/article/details/108206030
```

![如下图--基础包](D:/音乐图片/typora图片/image-20220812000739233.png)





::flags:  socket基础



[图解OSI七层模型 - 简书 (jianshu.com)](https://www.jianshu.com/p/9b9438dff7a2)





最基础的是物理层的计算机基础才能实现我们经常使用的各种协议来实现数据的传输

OSI(Open System Interconnection)，开放式系统互联参考模型 

物理层:（各种物理设备）集线器、中继器、调制解调器、网线、双绞线、同轴电缆

数据链路层:网卡、网桥、交换机

网络层:路由器、第三层交换机

传输层:各种协议、四层交换机（定义传输数据的协议端口号，以及流控和差错校验。协议有：TCP UDP，数据包一旦离开网卡即进入网络传输层）

应用层:计算机的各种数据（协议有：HTTP FTP TFTP SMTP SNMP DNS TELNET HTTPS POP3 DHCP）



http协议就是再再传输层，TCP在应用层

```

socket组为最基本的网络通讯基础组件，后来被封装成tomcat， tomcat又被封装成springweb，  后来为了更方便web服务器的开发，使用
springboot为基础更好的搭建项目，使用三层架构，快速搭建springmvc来完成 web服务器的开发。
注意web服务的网络传输 目前常见的httpRequest httpRespone 是基于http协议和工具socket进行数据的推送，完成数据的传输，最基础的原理就是字节流的 IO操作，也就是流读入和读出， 如果只是基础常见的数据类型String  int 等，就不会存在 编译和反编译的问题

由于socket数据传输的最大特点是阻塞性,后面 公司开发出Netty用于快速高效的开发网路应用，解决了socket的缺点并提搞了，安全性
这里对比就不做赘述了

但是java和python是 面向对象编程的语言， 特别现在由于微服务的出现，必须在网页传输的效率的问题上，提高效率和安全性，
如果使用java自己默认处理序列化问题，会有众多问题；为了解决这个问题，后续出现我们出现的xml和json ,fastJson,（Kryo 序列化--红号称最快的序列化框架 ）来解决数据传输的序列化问题




```







 