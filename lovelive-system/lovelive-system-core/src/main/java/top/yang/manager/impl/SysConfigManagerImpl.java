package top.yang.manager.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import top.yang.component.SysConfigComponent;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.manager.SysConfigManager;

/**
 * @author PrideYang
 */
@Component
public class SysConfigManagerImpl extends BaseManagerImpl<SysConfigComponent, SysConfigDto, Long> implements SysConfigManager {


    public PageResult<SysConfigDto> findByQuery(SysConfigQuery sysConfigQuery) {
        return super.compoment.findByQuery(sysConfigQuery);
    }


    @Override
    public Class getEntityClass() {
        return null;
    }

}
