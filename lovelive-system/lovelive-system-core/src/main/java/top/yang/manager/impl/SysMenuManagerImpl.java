package top.yang.manager.impl;

import top.yang.component.SysMenuComponent;
import top.yang.domain.dto.SysMenuDto;
import top.yang.manager.SysMenuManager;
import top.yang.domain.entity.SysMenu;
import org.springframework.stereotype.Component;

/**
 * @author PrideYang
 */
@Component
public class SysMenuManagerImpl extends BaseManagerImpl<SysMenuComponent, SysMenuDto, Long> implements SysMenuManager {

    @Override
    public Class getEntityClass() {
        return SysMenu.class;
    }
}