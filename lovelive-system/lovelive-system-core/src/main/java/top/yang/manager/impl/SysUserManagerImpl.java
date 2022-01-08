package top.yang.manager.impl;
import top.yang.component.SysUserComponent;
import top.yang.manager.SysUserManager;
import top.yang.domain.entity.SysUser;
import top.yang.domain.entity.SysUser;
import org.springframework.stereotype.Component;
@Component
public class SysUserManagerImpl extends BaseManagerImpl<SysUserComponent, SysUser, Long> implements SysUserManager {
    @Override
    public Class getEntityClass() {
        return SysUser.class;
    }
}