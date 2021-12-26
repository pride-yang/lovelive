package top.yang.manager.impl;

import top.yang.component.SysNoticeComponent;
import top.yang.domain.dto.SysNoticeDto;
import top.yang.manager.SysNoticeManager;
import top.yang.domain.entity.SysNotice;
import org.springframework.stereotype.Component;

/**
 * @author PrideYang
 */
@Component
public class SysNoticeManagerImpl extends BaseManagerImpl<SysNoticeComponent, SysNoticeDto, Long> implements SysNoticeManager {

    @Override
    public Class getEntityClass() {
        return SysNotice.class;
    }
}