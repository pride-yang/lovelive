package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysConfig;
import top.yang.mapper.SysConfigMapper;

/**
 * @author PrideYang
 */
public class SysConfigComponent extends BaseJdbcComponent<SysConfigMapper, SysConfig, Long> {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    protected SysConfigMapper getRepository() {
        return sysConfigMapper;
    }
}
