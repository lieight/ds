
使用配置的方式实现连接多个数据库

http://www.mydlq.club/article/105/


1、application.properties中设置连接参数


spring.datasource.db1.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.db1.jdbc-url = jdbc:mysql://10.100.1.22:3306/lighdb?characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&allowMultiQueries=true&serverTimezone=GMT%2B8
spring.datasource.db1.username = root
spring.datasource.db1.password = KingPrbt@123


spring.datasource.db2.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.db2.jdbc-url = jdbc:mysql://localhost:3306/lighdb?characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&allowMultiQueries=true&serverTimezone=GMT%2B8
spring.datasource.db2.username = root
spring.datasource.db2.password = KingPrbt@123

2、添加config自动配置类，参见config目录中的两个类信息

Db1DataSourceConfig
Db2DataSourceConfig

里面指明了那个数据源使用的连接配置参数以及使用的mapper文件

3、其他的dao/mapper/service就正常编写即可
