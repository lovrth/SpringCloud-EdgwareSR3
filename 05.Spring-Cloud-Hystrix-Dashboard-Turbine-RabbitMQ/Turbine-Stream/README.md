#### Turbine集群监控
> Turbine从Eureka服务注册中心通过服务名Ribbon-Consumer获取服务实例，然后Hystrix Dashboard对Turbine进行监控，这样就实现了Hystrix Dashboard同时对多个Hystrix（Ribbon-consumer）实例同时进行监控
- 改造Turbine让其从RabbitMQ中读取监控信息