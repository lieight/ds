通过引入插件的形式，实现一个程序中对接多个数据源

通过在pom中引入


		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>dynamic-datasource-spring-boot-starter</artifactId>
			<version>3.3.1</version>
		</dependency>

达到动态配置多数据源的目的

1、在pom中引入

		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>dynamic-datasource-spring-boot-starter</artifactId>
			<version>3.3.1</version>
		</dependency>

2、在application.properties中配置数据源，如下：


#设置默认的数据源或者数据源组，默认值即为 master
spring.datasource.dynamic.primary=db1
#设置严格模式，默认false不启动. 启动后在未匹配到指定数据源时候会抛出异常,不启动则使用默认数据源。
spring.datasource.dynamic.strict=false


spring.datasource.dynamic.datasource.db1.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.dynamic.datasource.db1.url = jdbc:mysql://10.100.1.22:3306/lighdb?characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&allowMultiQueries=true&serverTimezone=GMT%2B8
spring.datasource.dynamic.datasource.db1.username = root
spring.datasource.dynamic.datasource.db1.password = KingPrbt@123

spring.datasource.dynamic.datasource.db2.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.dynamic.datasource.db2.url = jdbc:mysql://localhost:3306/lighdb?characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&allowMultiQueries=true&serverTimezone=GMT%2B8
spring.datasource.dynamic.datasource.db2.username = root
spring.datasource.dynamic.datasource.db2.password = KingPrbt@123


## 配置 mapper 对应的 xml 文件目录
mybatis.mapper-locations: classpath:mapper/db1/*.xml,classpath*:/mapper/db2/*.xml


3、dao层接口和mapper正常编写

4、在使用service层调用的地方，每个函数上面指明使用哪一个数据库进行操作


    @DS("db1")
    public List<Db1UserInfo> getDb1UserInfoList(Long id){
        ...
    }


    @DS("db2")
    public List<Db2UserInfo> getDb2UserInfoList(Long id){
        ...
    }


    @DS("db2")
