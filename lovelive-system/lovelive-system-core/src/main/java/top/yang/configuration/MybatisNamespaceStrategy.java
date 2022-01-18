package top.yang.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;

/**
 * @author PrideYang
 */
@Configuration
public class MybatisNamespaceStrategy implements NamespaceStrategy {

    /**
     * mybatis XML命名空间
     *
     * @param domainType
     * @return
     */
    @Override
    public String getNamespace(Class<?> domainType) {
        return "top.yang.mapper.".concat(domainType.getSimpleName()).concat("Repository");
    }
}
