package top.yang.manager;

import org.springframework.stereotype.Component;
import top.yang.domain.entity.SysRole;
import top.yang.mapper.SysRoleRepository;

/**
 * @author pride
 */
@Component
public class SysRoleManager extends BaseManager<SysRoleRepository, SysRole, Long> {

}