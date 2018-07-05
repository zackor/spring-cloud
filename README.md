# Spring Cloud Demo For RRTX
## Quick Start
1. 启动Consul注册中心
   * [下载Consul](https://www.consul.io/downloads.html)
   * 启动，参考[官方资料](https://www.consul.io/intro/getting-started/agent.html)
   
```
./consul  agent  -dev
```

2. 启动Config Server
3. 启动Message

## 问题记录
-  配置中心增加权限验证后如何是今后换密码时不至于修改多个配置文件（考虑Config Server 公共配置）
-  配置中心配置自动刷新（git中配置文件修改后，配置中心是可以实时拿到最新版本，但各个微服务不能，需要人工POST /refresh  @RefreshScope才能重新加载参数 框架中要如何设计比较好？）
## 知识点
- Config配置文件鉴权及加密
- Consul注册中心生成集群配置


## 注意点
- 非对称加密生成证书
```
 keytool -genkeypair -alias config-server -keyalg RSA -keystore config-server.keystore
```
- EndPoint无权访问
```
#在配置文件中增加配置
management:
  security:
    enabled: false
```
- 本地配置文件和运行参数及Config Server配置文件的覆盖关系


