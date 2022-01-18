package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.yang.domain.entity.SysDictData;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;

/**
 * @author pride
 */
@Mapper
@Repository
public interface SysDictDataRepository extends BaseJdbcRepository<SysDictData, Long> {


}