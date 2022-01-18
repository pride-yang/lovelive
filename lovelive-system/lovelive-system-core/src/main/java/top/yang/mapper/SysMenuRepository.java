package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.yang.domain.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;

/**
 * @author pride
 */
@Repository
public interface SysMenuRepository extends BaseJdbcRepository<SysMenu, Long> {


}