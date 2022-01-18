package top.yang.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.yang.domain.entity.SysConfig;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.domain.query.SysConfigQuery;
import top.yang.repository.BaseJdbcRepository;;

/**
 * @author pride
 */
@Repository
public interface SysConfigRepository extends BaseJdbcRepository<SysConfig, Long> {



}