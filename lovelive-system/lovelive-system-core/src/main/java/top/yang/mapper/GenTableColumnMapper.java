package top.yang.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.GenTableColumn;
import top.yang.repository.BaseJdbcRepository;

/**
 * 业务字段 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface GenTableColumnMapper extends BaseJdbcRepository<GenTableColumn, Long> {

  /**
   * 根据表名称查询列信息
   *
   * @param tableName 表名称
   * @return 列信息
   */
  public List<GenTableColumn> selectDbTableColumnsByName(String tableName);

  /**
   * 查询业务字段列表
   *
   * @param tableId 业务字段编号
   * @return 业务字段集合
   */
  public List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);


}
