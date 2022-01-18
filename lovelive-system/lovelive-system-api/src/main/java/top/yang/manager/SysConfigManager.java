package top.yang.manager;

import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;

/**
 * @author pride
 */
public interface SysConfigManager extends BaseManager<SysConfig, Long> {

    PageResult<SysConfigDto> search(SysConfigQuery sysConfig);
}