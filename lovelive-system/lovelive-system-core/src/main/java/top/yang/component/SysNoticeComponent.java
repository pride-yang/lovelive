package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysNotice;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysNoticeMapper;

/**
 * @author PrideYang
 */
@Component
public class SysNoticeComponent extends BaseJdbcComponent<SysNoticeMapper, SysNotice, Long>{

    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    @Override
    protected SysNoticeMapper getRepository() {
        return sysNoticeMapper;    }
}