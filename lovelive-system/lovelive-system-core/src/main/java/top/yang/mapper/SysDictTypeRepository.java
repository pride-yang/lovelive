package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.yang.domain.entity.SysDictType;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;
@Mapper@Repository
public interface SysDictTypeRepository extends BaseJdbcRepository<SysDictType, Long>{


}