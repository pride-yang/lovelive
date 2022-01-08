package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysUser;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysUserMapper;
@Component
public class SysUserComponent extends BaseJdbcComponent<SysUserMapper, SysUser, Long>{

    @Autowired
    private SysUserMapper sysUserMapper;


}