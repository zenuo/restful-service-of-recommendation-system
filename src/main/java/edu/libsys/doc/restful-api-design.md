# RESTful API设计
>通过以下的api存取图书（book）、论文（paper）等资源。

## 1.图书部分
|功能|资源地址|示例|
| --- | --- | --- |
|添加|POST /books|POST /books|
|删除|DELETE /books/{id}|DELETE /books/1|
|更新|PUT /books/{id}|PUT /books/1|
|获得单个|GET /books/{id}|GET /books/1|
|获得多个|GET /books/get?page={page}&size={size}|GET /books/get?page=1&size=10|
|关键词查询|GET /books/search?keyword={keyword}|GET /books/search?keyword=马克思|

## 2.论文部分
|功能|资源地址|示例|
| --- | --- | --- |
|添加|POST /papers|POST /papers|
|删除|DELETE /papers/{id}|DELETE /papers/1|
|更新|PUT /papers/{id}|PUT /papers/1|
|获得单个|GET /papers/{id}|GET /papers/1|
|获得多个|GET /papers/get?page={page}&size={size}|GET /papers/get?page=1&size=10|
|关键词查询|GET /papers/search?keyword={keyword}|GET /papers/search?keyword=马克思|

## 3.推荐部分
|功能|资源地址|示例|
| --- | --- | --- |
|根据图书ID获取论文推荐|GET /recommend/papers?id={id}&type=book|GET /recommend/papers?id=1&type=book|
|根据论文ID获取论文推荐|GET /recommend/papers?id={id}&type=paper|GET /recommend/papers?id=1&type=paper|
|根据图书ID获取图书推荐|GET /recommend/books?id={id}&type=book|GET /recommend/books?id=1&type=book|
|根据论文ID获取图书推荐|GET /recommend/books?id={id}&type=paper|GET /recommend/books?id=1&type=paper|
