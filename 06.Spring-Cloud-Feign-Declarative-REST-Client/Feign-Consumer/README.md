#### Feign-Consumer
- 内部的客户端负载均衡是通过Ribbon来实现的,轮询实现了客户端负载均衡
- Spring Cloud Feign中开启Hystrix
```yaml
feign:
  hystrix:
    enabled: true
```
- 服务降级（实现Feign服务调用的接口）
- Feign配置
    - 请求压缩
    - 日志配置
