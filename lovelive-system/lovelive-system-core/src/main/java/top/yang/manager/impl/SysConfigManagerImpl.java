package top.yang.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.component.SysConfigComponent;
import top.yang.convers.SysConfigConver;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.query.SysConfigQuery;
import top.yang.manager.SysConfigManager;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.entity.SysConfig;
import org.springframework.stereotype.Component;

@Component
public class SysConfigManagerImpl extends BaseManagerImpl<SysConfigComponent, SysConfig, Long> implements SysConfigManager {

    @Override
    public Class getEntityClass() {
        return SysConfig.class;
    }

    @Override
    public PageResult<SysConfigDto> search(SysConfigQuery sysConfig) {
        PageResult<SysConfig> search = component.search(sysConfig);
        return SysConfigConver.INSTANCE.entityToDtoPage(search);
    }
}