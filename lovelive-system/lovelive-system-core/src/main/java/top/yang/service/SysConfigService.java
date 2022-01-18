package top.yang.service;

import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.dto.SysConfigDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.domain.query.SysConfigQuery;
import top.yang.manager.SysConfigManager;
import top.yang.manager.impl.SysConfigManagerImpl;
import top.yang.request.SysConfigReq;

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
        return sysConfigManager.search(sysConfig);
    }
}