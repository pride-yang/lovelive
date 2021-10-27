package top.yang.configuration;

import java.time.LocalDateTime;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.mybatis.MyBatisDataAccessStrategy;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import top.yang.pojo.BaseIdEntity;
import top.yang.utils.SnowFlake;

/**
 * @author PrideYang
 */
@Configuration(proxyBeanMethods = false)
public class MyBatisJdbcConfiguration extends AbstractJdbcConfiguration {


  private @Autowired
  SqlSession session;
  @Autowired
  private SnowFlake snowFlake;

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

    return MyBatisDataAccessStrategy.createCombinedAccessStrategy(context, jdbcConverter, operations, session, new MybatisNamespaceStrategy(), new MySqlDialect());
  }

  /**
   * 保存之前处理id或更新创建时间
   *
   * @return
   */
  @Bean
  BeforeSaveCallback<BaseIdEntity> beforeSaveCallback() {

    return (baseIdEntity, mutableAggregateChange) -> {
      if (baseIdEntity.getCreateTime() == null) {
        baseIdEntity.setCreateTime(LocalDateTime.now());
      }
      baseIdEntity.setUpdateTime(LocalDateTime.now());
      if (baseIdEntity.getId() == null) {
        baseIdEntity.setId(snowFlake.nextId());
      }
      return baseIdEntity;
    };
  }

}
