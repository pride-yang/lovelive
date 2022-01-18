package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysUser;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysUserRepository;

@Component
public class SysUserComponent extends BaseJdbcComponent<SysUserRepository, SysUser, Long>{

    @Autowired
    private SysUserRepository sysUserRepository;


}