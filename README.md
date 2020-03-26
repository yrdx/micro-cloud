# micro-cloud
本项目基于spring-cloud框架，打造程序员的专属社交平台，包括头条、问答、活动、交友、吐槽、招聘六大 频道.
## 项目结构

| 模块 | 名称 | 端口 | |
| --- | --- | --- | --- |
| `micro-web` | API层 | HTTP  | |
| `micro-article` | 文章 HTTP 服务 | HTTP 9004 |
| `micro-base` | 基础 HTTP 服务 | HTTP 9001 |
| `micro-qa` | 问答 HTTP 服务 | HTTP 9003 |
| `micro-search` | 搜索 HTTP 服务 | HTTP 9007 |
| `micro-spit` | 吐槽 HTTP 服务 | HTTP 9006 |
| `micro-manager` |  | HTTP 18086 |
| `micro-recruit` | 招聘 HTTP 服务 | HTTP 9002 |
| `micro-eureka` | 服务注册中心服务 |  |
| `micro-common` | 公共工具类 |  |
| `micro-gathering` | 活动 HTTP 服务 | HTTP 9005 |
| `micro-doc` | 文档说明 |  |

-------
## 技术栈

### 后端

| 框架 | 说明 |  版本 |
| --- | --- | --- |
| [Spring boot] | 应用开发框架 |   2.0.1.RELEASE |
| [Spring cloud] | 应用开发框架 |   Finchley.M9 |
| [MySQL](https://www.mysql.com/cn/) | 数据库服务器 | 5.6 |
| [JPA]| 数据持久层框架 | 2.0.6.RELEASE |
| [Redis](https://redis.io/) | key-value 数据库 |  |
| [RedisTemplate] | Redis 客户端 | 2.0.6.RELEASE |
| [Elasticsearch](https://www.elastic.co/cn/) | 分布式搜索引擎 | 5.6.8 |
| [mongodb] | mongodb数据库 | |
| [logstash] | 日志搜索处理框架 | 5.6.8



