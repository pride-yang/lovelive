package top.yang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.convers.SysConfigConver;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.manager.SysConfigManager;

/**
 * @author PrideYang
 */
@Service
public class SysConfigService {

    @Autowired
    private SysConfigManager sysConfigManager;

    public void saveOrUpdate(SysConfig sysConfig) {
        sysConfigManager.save(sysConfig);
    }

    public PageResult<SysConfigDto> search(SysConfigQuery sysConfig) {
        PageResult<SysConfigDto> result = SysConfigConver.INSTANCE.entityToDtoPage(sysConfigManager.search(sysConfig));
        return result;
    }
}