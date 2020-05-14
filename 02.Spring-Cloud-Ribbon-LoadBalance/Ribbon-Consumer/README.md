#### Eureka-Consumer
> Eureka客户端即是服务提供者，也是服务消费者，即自身的接口可能被别的服务访问，同时也可能调用别的服务接口。这里为了更好的演示，把服务消费者单独的分开来演示。
- 服务消费者
- 例子使用Ribbon负载均衡完成服务消费(用户增删改查)
    - getForObject方法相当于getForEntity方法调用了getBody方法，直接返回结果对象，为不是ResponseEntity对象（方法参数除了可以放在数组里外，也可以放在Map里）
    - postForEntity、postForObject
    - put
    - delete

