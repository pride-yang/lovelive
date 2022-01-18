package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;

/**
* @author pride
* @description 针对表【sys_config(参数配置表)】的数据库操作Mapper
* @createDate 2022-01-10 21:07:29
* @Entity generator.domain.SysConfig
*/
@Mapper
public interface SysConfigMapper {
    List<SysConfig> searchByQuery(SysConfigQuery query);

    Long countByQuery(SysConfigQuery query);
}




