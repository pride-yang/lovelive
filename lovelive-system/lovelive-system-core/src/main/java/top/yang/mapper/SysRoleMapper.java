package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;
@Mapper
public interface SysRoleMapper extends BaseJdbcRepository<SysRole, Long>{


}