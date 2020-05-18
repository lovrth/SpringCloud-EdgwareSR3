#### Config-Client 客户端
- 必须命名为bootstrap.yml
- 刷新配置(post):http://localhost:12581/refresh
> Git仓库存储的配置得到改变的时候也刷新Config-Client中获取到的配置值
- 加入注册中心
    - 访问效果：http://localhost:12581/message
> 只对单个Config-Client有效（往哪个Config-Client发送刷新请求，哪个配置就得到刷新，剩下的Config-Client获取的仍是旧的配置信息）
，借助Spring Cloud Bus来自动刷新集群的配置信息

