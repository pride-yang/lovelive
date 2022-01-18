package top.yang.configuration;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.mybatis.MyBatisDataAccessStrategy;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

/**
 * @author PrideYang
 */
@Configuration
@EnableJdbcRepositories(basePackages = "top.yang.mapper")
public class MyBatisJdbcConfiguration extends AbstractJdbcConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MyBatisJdbcConfiguration.class);

    private @Autowired
    SqlSession session;

    /**
     * 自定义mybatis命名空间
     *
     * @param operations
     * @param jdbcConverter
     * @param context
     * @param dialect
     * @return
     */
    @Bean
    @Override
    public DataAccessStrategy dataAccessStrategyBean(NamedParameterJdbcOperations operations, JdbcConverter jdbcConverter,
            JdbcMappingContext context, Dialect dialect) {

        return MyBatisDataAccessStrategy.createCombinedAccessStrategy(context, jdbcConverter, operations, session, new MybatisNamespaceStrategy(), dialect);
    }

}
