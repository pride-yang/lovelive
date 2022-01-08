package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;
@Mapper
public interface SysUserMapper extends BaseJdbcRepository<SysUser, Long>{


}