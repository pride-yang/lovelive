package top.yang.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.domain.dto.PageResult;
import top.yang.domain.query.SysConfigQuery;
import top.yang.response.SysConfigReq;
import top.yang.manager.impl.SysConfigManagerImpl;

/**
 * @author PrideYang
 */
@Service
public class SysConfigService {

    @Autowired
    private SysConfigManagerImpl configManager;

    public PageResult<SysConfigReq> findListByPage(SysConfigQuery sysConfigQuery) {
        return null;
    }
}
