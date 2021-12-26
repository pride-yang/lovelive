package top.yang.manager.impl;

import top.yang.component.SysRoleComponent;
import top.yang.domain.dto.SysRoleDto;
import top.yang.manager.SysRoleManager;
import top.yang.domain.entity.SysRole;
import org.springframework.stereotype.Component;

/**
 * @author PrideYang
 */
@Component
public class SysRoleManagerImpl extends BaseManagerImpl<SysRoleComponent, SysRoleDto, Long> implements SysRoleManager {

    @Override
    public Class getEntityClass() {
        return SysRole.class;
    }
}