package top.yang.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.manager.impl.SysConfigManagerImpl;

/**
 * @author PrideYang
 */
@Service
public class SysConfigService {

    @Autowired
    private SysConfigManagerImpl configManager;

    public PageResult<SysConfigDto> findListByQuery(SysConfigQuery sysConfigQuery) {
        return configManager.findByQuery(sysConfigQuery);
    }

    public SysConfigDto findByConfigId(Long configId) {
        return null;
    }

    public void deleteConfigByIds(Long[] configIds) {
        configManager.deleteByIds(List.of(configIds));
    }

    public void save(SysConfigDto config) {
        configManager.save(config);
    }
}
