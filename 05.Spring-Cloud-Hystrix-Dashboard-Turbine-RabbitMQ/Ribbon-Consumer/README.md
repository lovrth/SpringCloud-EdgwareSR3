#### Ribbon-Consumer
> Eureka客户端即是服务提供者，也是服务消费者，即自身的接口可能被别的服务访问，同时也可能调用别的服务接口。这里为了更好的演示，把服务消费者单独的分开来演示。
- 服务消费者
- 例子使用Ribbon负载均衡完成服务消费(用户增删改查)
    - getForObject方法相当于getForEntity方法调用了getBody方法，直接返回结果对象，为不是ResponseEntity对象（方法参数除了可以放在数组里外，也可以放在Map里）
    - postForEntity、postForObject
    - put
    - delete
- 例子使用Hystrix服务容错
> Hystrix会根据组来组织和统计命令的告警、仪表盘等信息。默认情况下，Hystrix命令通过组名来划分线程池，即组名相同的命令放到同一个线程池里，如果通过threadPoolKey设置了线程池名称，则按照线程池名称划分。

> 请求合并就是将多个单个请求合并成一个请求，去调用服务提供者，从而降低服务提供者负载的，一种应对高并发的解决办法。
@HystrixCollapser注解,实际中是否该使用Hystrix的请求合并功能，需结合实际需求进行抉择
- 加入rabittmq依赖，将熔断监控信息输出到RabbitMQ
