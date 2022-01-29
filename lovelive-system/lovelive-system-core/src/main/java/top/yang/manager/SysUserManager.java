package top.yang.manager;

import org.springframework.stereotype.Component;
import top.yang.domain.entity.SysUser;
import top.yang.mapper.SysUserRepository;

/**
 * @author pride
 */
@Component
public class SysUserManager extends BaseManager<SysUserRepository, SysUser, Long> {

}