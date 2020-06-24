# blog
A personal blog

### 技术栈
- 数据库使用 Mysql
- 缓存中间件使用 Redis
- 使用后端框架 SpringBoot 进行整合


### 特点
- 使用 Cookie 记录用户的登录状态，进而解决 http 协议无状态的缺陷。
- 使用 Redis 的集合数据结构来实现文章的点赞与反对，用户的关注与取关。
- 采用 Redis 的列表数据结构实现了一个基于生产/消费者的小型异步框架，比如用户点赞之后立即返回，被点赞用户的通知存放在异步队列中等待其它线程处理，从而提高请求的响应速度。
- 文章列表的分页查询以及文章删除、发布、修改均使通过 Ajax 方式向后台提交请求来避免频繁刷新页面，提高用户体验感。
