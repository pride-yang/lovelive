package top.yang.configuration;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.mybatis.MyBatisDataAccessStrategy;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import top.yang.domain.pojo.BaseEntity;
import top.yang.domain.pojo.BaseIdEntity;
import top.yang.string.StringUtils;
import top.yang.utils.SnowFlake;

/**
 * @author PrideYang
 */
@Configuration(proxyBeanMethods = false)
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
    @NotNull
    @Override
    @Bean
    public DataAccessStrategy dataAccessStrategyBean(@NotNull NamedParameterJdbcOperations operations, @NotNull JdbcConverter jdbcConverter,
            @NotNull JdbcMappingContext context, @NotNull Dialect dialect) {

        return MyBatisDataAccessStrategy.createCombinedAccessStrategy(context, jdbcConverter, operations, session, new MybatisNamespaceStrategy(),
                dialect);
    }


}
