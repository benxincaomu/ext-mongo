# ext-mongo说明文档

## 开发说明

### 原因

mongo-java-driver.jar是mongodb官方提供的java驱动包，对于库的操作分了两个体系,而且本身都不直接支持对自定义java对象的写入和读取。

#### 1.DB-DBCollection

DBCollection中对集合操作有返回值，并且用findOne方法可以获取一个符合条件的对象。但是DBCollection并没有采用泛型定义，需要在业务代码中进行类型转换。

#### 2.MongoDatabase-MongoCollection

MongoCollection支持泛型，可以很方便的定制对自定义java对象的各种操作。但是insertOne()和insertMany()都无返回值，而且缺少findOne()方法，不利于获取insert操作的结果和符合条件的唯一对象。

这个插件的目的就是讲这两个体系的优点结合起来，并尽量支持自定义java类的操作。

