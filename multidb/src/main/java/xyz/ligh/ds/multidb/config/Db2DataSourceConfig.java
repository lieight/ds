package xyz.ligh.ds.multidb.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = Db2DataSourceConfig.PACKAGE, sqlSessionFactoryRef = Db2DataSourceConfig.SQL_SESSION_FACTORY)
public class Db2DataSourceConfig {

    /** 指定 Sql Session Factory 的 Bean 名称 */
    static final String SQL_SESSION_FACTORY = "db2SqlSessionFactory";
    /** 指定 Mapper 类的包路径 */
    static final String PACKAGE = "xyz.ligh.ds.multidb.dao.db2";
    /** 指定数据库 Mapper 对应的 xml 文件路径 */
    static final String MAPPER = "classpath:mapper/db2/*.xml";

    /**
     * 配置数据源，这里设置为 hikari 数据库连接池
     * @return DataSource
     */
    @Bean(name = "db2DataSource")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    /**
     * 数据源事务管理器
     * @return 数据源事务管理器
     */
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2DataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(Db2DataSourceConfig.MAPPER));
        return sessionFactory.getObject();
    }


    /**
     @ConfigurationProperties：从配置文件中读取指定前缀的配置参数。
     @MapperScan：指定数据库配置对哪些包的 Mapper 生效，指定数据库 SQL 会话工厂。
     @Primary：声明这是一个主数据源（默认数据源），多数据源配置时必不可少。
     @Qualifier：显式选择传入的 Bean，根据配置的名称指定使用哪个 Bean。
     */

}
