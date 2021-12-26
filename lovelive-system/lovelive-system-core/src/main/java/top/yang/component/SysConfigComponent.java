package top.yang.component;

import java.util.List;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.mapper.SysConfigMapper;

/**
 * @author PrideYang
 */
public class SysConfigComponent extends BaseJdbcComponent<SysConfigMapper, SysConfig, Long> {

    public PageResult<SysConfigDto> findByQuery(SysConfigQuery sysConfigQuery) {
        long count = this.repository.countByQuery(sysConfigQuery);
        List<SysConfig> resultList = this.repository.findByQuery(sysConfigQuery);
        return null;
    }
}
