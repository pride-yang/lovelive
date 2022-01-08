package top.yang.manager.impl;
import top.yang.component.SysRoleComponent;
import top.yang.manager.SysRoleManager;
import top.yang.domain.entity.SysRole;
import top.yang.domain.entity.SysRole;
import org.springframework.stereotype.Component;
@Component
public class SysRoleManagerImpl extends BaseManagerImpl<SysRoleComponent, SysRole, Long> implements SysRoleManager {
    @Override
    public Class getEntityClass() {
        return SysRole.class;
    }
}