package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yang.domain.entity.SysMenu;
import top.yang.mapper.SysMenuMapper;

/**
 * @author PrideYang
 */
@Component
public class SysMenuComponent extends BaseJdbcComponent<SysMenuMapper, SysMenu, Long> {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    protected SysMenuMapper getRepository() {
        return sysMenuMapper;
    }
}