# RESTful API设计
>通过以下的api存取图书（book）、论文（paper）、收藏（collection）、行为（behavior）等资源。

## 1.图书部分
|功能|资源地址|示例|
| --- | --- | --- |
|添加|POST /books|POST /books|
|删除|DELETE /books/{id}|DELETE /books/1|
|更新|PUT /books/{id}|PUT /books/1|
|获得单个|GET /books/{id}|GET /books/1|
|获得多个|GET /books/get?page={page}&size={size}|GET /books/get?page=1&size=10|
|关键词查询|GET /books/search?keyword={keyword}|GET /books/search?keyword=马克思|
|根据图书ID获取论文推荐|GET /books/recommend?id={id}|GET /books/recommend?id=1|

## 2.论文部分
|功能|资源地址|示例|
| --- | --- | --- |
|添加|POST /papers|POST /papers|
|删除|DELETE /papers/{id}|DELETE /papers/1|
|更新|PUT /papers/{id}|PUT /papers/1|
|获得单个|GET /papers/{id}|GET /papers/1|
|获得多个|GET /papers/get?page={page}&size={size}|GET /papers/get?page=1&size=10|
|关键词查询|GET /papers/search?keyword={keyword}|GET /papers/search?keyword=马克思|
|根据论文ID获取图书推荐|GET /papers/recommend?id={id}|GET /papers/recommend?id=1|

## 3.收藏部分
|功能|资源地址|示例|
| --- | --- | --- |
|添加|PUT /collections?userid={userid}|PUT /collections?userid=1|
|删除|DELETE /collections?userid={userid}&collectionid={collectionid}|DELETE /collections?userid=1&collectionid=1|

## 4.行为部分
|功能|资源地址|示例|
| --- | --- | --- |
|反馈|POST /behaviors|POST /behaviors|