#### Zipkin-Server 日志获取与分析
- Collector：收集器，负责收集日志信息，以供后续的存储，分析与展示；
- Storage：存储模块，我们可以通过它将日志存储到MySQL中；
- RESTful API：API组件，它主要用来提供外部访问接口。 比如给客户端展示跟踪信息，或是外接系统访问以实现监控等；
- WEB UI：通过web页面，我们可以轻松的分析与跟踪请求日志。
- 日志数据储存到mysql
- Zipkin提供了RESTful API，如http://localhost:9100/api/v1/services


