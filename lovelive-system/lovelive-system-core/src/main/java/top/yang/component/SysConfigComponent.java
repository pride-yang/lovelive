package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysConfig;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysConfigMapper;
@Component
public class SysConfigComponent extends BaseJdbcComponent<SysConfigMapper, SysConfig, Long>{

    @Autowired
    private SysConfigMapper sysConfigMapper;


}