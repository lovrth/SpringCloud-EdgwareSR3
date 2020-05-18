#### Config-Server
> 对微服务配置进行统一的外部管理，并且默认采用Git来管理配置信息
- febs.yml
```yaml
message: 'default properties (master v1.0)'
```
- febs-dev.yml
```yaml
message: 'dev properties (master v1.0)'
```
- febs-test.yml
```yaml
message: 'test properties (master v1.0)'
```
- febs-pro.yml
```yaml
message: 'pro properties (master v1.0)'
```

> test分支，同样push这四个配置文件，不过配置文件中message属性的内容末尾都改为了(test v1.0)

> Config-Server中包含了Git连接信息，通过Spring Security来做用户名密码认证，Config-Server中Git仓库的密码是直接明文配置的，对这些敏感信息进行加密处理
，可使用对称加密和非对称加密

- 对Config-Server进行集群处理,并加入注册中心
- 刷新配置（post）：curl -u lovrth:123456 -X POST http://localhost:12580/bus/refresh
- 配合WebHooks技术可以实现自动配置刷新，在配置得到修改的时候可以代替向Config-Server发送刷新请求



