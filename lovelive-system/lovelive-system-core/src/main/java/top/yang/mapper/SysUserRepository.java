package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.yang.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;

@Mapper
@Repository
public interface SysUserRepository extends BaseJdbcRepository<SysUser, Long> {


}