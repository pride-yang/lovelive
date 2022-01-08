package top.yang.manager.impl;
import top.yang.component.SysNoticeComponent;
import top.yang.manager.SysNoticeManager;
import top.yang.domain.entity.SysNotice;
import top.yang.domain.dto.SysNoticeDto;
import org.springframework.stereotype.Component;
@Component
public class SysNoticeManagerImpl extends BaseManagerImpl<SysNoticeComponent, SysNoticeDto, Long> implements SysNoticeManager {
    @Override
    public Class getEntityClass() {
        return SysNotice.class;
    }
}