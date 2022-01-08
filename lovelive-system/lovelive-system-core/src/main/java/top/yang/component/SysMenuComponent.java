package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysMenu;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysMenuMapper;
@Component
public class SysMenuComponent extends BaseJdbcComponent<SysMenuMapper, SysMenu, Long>{

    @Autowired
    private SysMenuMapper sysMenuMapper;


}