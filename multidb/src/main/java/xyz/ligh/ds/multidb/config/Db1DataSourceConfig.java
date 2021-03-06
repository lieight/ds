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
@MapperScan(basePackages = Db1DataSourceConfig.PACKAGE, sqlSessionFactoryRef = Db1DataSourceConfig.SQL_SESSION_FACTORY)
public class Db1DataSourceConfig {
    /** 指定 Sql Session Factory 的 Bean 名称 */
    static final String SQL_SESSION_FACTORY = "db1SqlSessionFactory";
    /** 指定 Mapper 类的包路径 */
    static final String PACKAGE = "xyz.ligh.ds.multidb.dao.db1";
    /** 指定数据库 Mapper 对应的 xml 文件路径 */
    static final String MAPPER = "classpath:mapper/db1/*.xml";

    /**
     * 配置数据源，这里设置为 hikari 数据库连接池
     *
     * ConfigurationProperties  中的内容必须和application.properties中的前缀匹配
     * @return DataSource
     */
    @Primary
    @Bean(name = "db1DataSource")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    /**
     * 数据源事务管理器
     * @return 数据源事务管理器
     */
    @Primary
    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db1DataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(Db1DataSourceConfig.MAPPER));
        return sessionFactory.getObject();
    }
}
