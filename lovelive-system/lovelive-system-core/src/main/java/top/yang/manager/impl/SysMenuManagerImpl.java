package top.yang.manager.impl;
import top.yang.component.SysMenuComponent;
import top.yang.manager.SysMenuManager;
import top.yang.domain.entity.SysMenu;
import top.yang.domain.entity.SysMenu;
import org.springframework.stereotype.Component;
@Component
public class SysMenuManagerImpl extends BaseManagerImpl<SysMenuComponent, SysMenu, Long> implements SysMenuManager {
    @Override
    public Class getEntityClass() {
        return SysMenu.class;
    }
}