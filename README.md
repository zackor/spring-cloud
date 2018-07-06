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
-  配置文件中的启动端口如何进行随机数配置
-  集成Spring Bus实现Config Service 配置自动刷新
-  如何通过Spring Bug 局部刷新
-  
## 知识点
- Config配置文件鉴权及加密
- Consul注册中心生成集群配置

## 思路
-- 通过WEB界面控制Config配置文件来实现各种参数的控制，已实现各种功能（负载均衡/限流/降级/容错/熔断/路由）
-- 通过Spring Bus实现Config配置自动刷新（需要用到Git webhook）
-- Spring Bus 有[局部刷新功能](http://www.itmuch.com/spring-cloud/spring-cloud-bus-auto-refresh-configuration/)，可配合路由配置功能实现灰度发布
-- 实现WEB界面控制参数功能，需要人工梳理出各个配置文件中配置KEY与各种功能的内部逻辑
-- 后期需要考虑监控功能集成
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


