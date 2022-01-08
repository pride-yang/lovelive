package top.yang.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysNotice;
import org.apache.ibatis.annotations.Mapper;;
import top.yang.repository.BaseJdbcRepository;;
@Mapper
public interface SysNoticeMapper extends BaseJdbcRepository<SysNotice, Long>{


}