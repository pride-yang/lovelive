package top.yang.manager.impl;
import top.yang.component.SysConfigComponent;
import top.yang.manager.SysConfigManager;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.dto.SysConfigDto;
import org.springframework.stereotype.Component;
@Component
public class SysConfigManagerImpl extends BaseManagerImpl<SysConfigComponent, SysConfigDto, Long> implements SysConfigManager {
    @Override
    public Class getEntityClass() {
        return SysConfig.class;
    }
}