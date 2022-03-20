package top.yang.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.api.SysConfigApi;
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
@DubboService(version = "1.0.0") // 暴露接口的注解
public class SysConfigService implements SysConfigApi {

    @Autowired
    private SysConfigManager sysConfigManager;

    public void saveOrUpdate(SysConfig sysConfig) {
        sysConfigManager.save(sysConfig);
    }
    @Override
    public PageResult<SysConfigDto> search(SysConfigQuery sysConfig) {
        PageResult<SysConfigDto> result = SysConfigConver.INSTANCE.entityToDtoPage(sysConfigManager.search(sysConfig));
        return result;
    }
}