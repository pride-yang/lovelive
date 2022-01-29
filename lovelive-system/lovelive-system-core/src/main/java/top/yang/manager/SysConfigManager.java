package top.yang.manager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.manager.BaseManager;
import top.yang.mapper.SysConfigMapper;
import top.yang.mapper.SysConfigRepository;
import top.yang.utils.PageUtils;

/**
 * @author pride
 */
@Component
public class SysConfigManager extends BaseManager<SysConfigRepository, SysConfig, Long> {

    @Autowired
    private SysConfigMapper mapper;

    public PageResult<SysConfig> search(SysConfigQuery sysConfigQuery) {
        List<SysConfig> search = mapper.searchByQuery(sysConfigQuery);
        Long count = mapper.countByQuery(sysConfigQuery);
        return PageUtils.buildPage(search, (int) (count / sysConfigQuery.getPageSize()), count, sysConfigQuery.getPage());

    }
}