package top.yang.component;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.SysConfig;
import org.springframework.stereotype.Component;
import top.yang.domain.query.SysConfigQuery;
import top.yang.mapper.SysConfigMapper;
import top.yang.mapper.SysConfigRepository;
import top.yang.utils.PageUtils;

/**
 * @author pride
 */
@Component
public class SysConfigComponent extends BaseJdbcComponent<SysConfigRepository, SysConfig, Long> {

    @Autowired
    private SysConfigMapper mapper;

    public PageResult<SysConfig> search(SysConfigQuery sysConfigQuery) {
        List<SysConfig> search = mapper.searchByQuery(sysConfigQuery);
        Long count = mapper.countByQuery(sysConfigQuery);
        return PageUtils.buildPage(search, (int) (count / sysConfigQuery.getPageSize()), count, sysConfigQuery.getPage());

    }
}