#### Server-Provider1
- 注册到服务中心
- 使用ribbon消費Server-Provider2的接口
- 添加服务追踪的sleuth（日志跟踪）
```
[server-provider1,939ca3c1d060ed40,3f31114e88154074,false]
1. server-provider1微服务的名称，与spring.application.name对应；
2. 939ca3c1d060ed40称为Trace ID，在一条完整的请求链路中，这个值是固定的。
3. 3f31114e88154074称为Span ID，它表示一个基本的工作单元；
4. false表示是否要将该信息输出到Zipkin等服务中来收集和展示，这里还没有集成Zipkin，所以为false。
```
- 访问（查看日志及zipkin）：http://localhost:9000/hello


