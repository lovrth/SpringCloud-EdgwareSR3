#### Hystrix Dashboard仪表盘
> Hystrix提供了Hystrix Dashboard来实时监控Hystrix的运行情况
- 例子监控单个Hystrix
    - 启动页面：http://localhost:9002/hystrix
    - 监控添加熔断器的服务Ribbon-Consumer：http://localhost:9000/hystrix.stream
> 向Ribbon-Consumer发几条请求（添加@HystrixCommand的方法），查看监控页面
，主要监控Circuit和Thread Pools（实时监控，无需刷新页面）
- 监控多个Hystrix实例
    - 监控添加Turbine服务:http://localhost:9003/turbine.stream
