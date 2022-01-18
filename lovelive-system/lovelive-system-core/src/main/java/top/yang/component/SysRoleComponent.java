package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysRole;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysRoleRepository;

@Component
public class SysRoleComponent extends BaseJdbcComponent<SysRoleRepository, SysRole, Long>{

    @Autowired
    private SysRoleRepository sysRoleRepository;


}