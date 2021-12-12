package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysRole;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysRoleMapper;

/**
 * @author PrideYang
 */
@Component
public class SysRoleComponent extends BaseJdbcComponent<SysRoleMapper, SysRole, Long>{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    protected SysRoleMapper getRepository() {
        return sysRoleMapper;    }
}