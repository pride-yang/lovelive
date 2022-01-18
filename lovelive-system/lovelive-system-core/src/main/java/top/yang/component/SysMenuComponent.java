package top.yang.component;

import top.yang.domain.entity.SysMenu;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysConfigRepository;
import top.yang.mapper.SysMenuRepository;

/**
 * @author pride
 */
@Component
public class SysMenuComponent extends BaseJdbcComponent<SysMenuRepository, SysMenu, Long> {

    public SysMenuComponent() {

    }
}