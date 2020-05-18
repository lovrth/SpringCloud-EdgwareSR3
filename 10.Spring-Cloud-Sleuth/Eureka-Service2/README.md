#### Eureka-Service
- 服务注册中心
- 地址：http://localhost:8081/

>EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY’RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
- 当Eureka服务端在短时间内同时丢失了过多的Eureka客户端时，Eureka服务端会进入保护模式，不去剔除这些客户端。因为我们这里只部署了一个Eureka客户端服务，所以关闭客户端后满足“短时间内丢失过多Eureka客户端”的条件
```
eureka:
  server:
    enable-self-preservation: false
```

- 启用集群模式
> 单节点的Eureka服务端宕机了，那么所有服务都无法正常的访问，这必将是灾难性的。为了提高Eureka服务端的可用性，一般会对其集群部署
- 启用用户认证
> 出于安全的考虑，会对Eureka服务端添加用户认证的功能