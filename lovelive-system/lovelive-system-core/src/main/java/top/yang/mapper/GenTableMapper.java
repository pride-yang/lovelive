package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.GenTable;
import top.yang.domain.query.GenTableQuery;
import top.yang.repository.BaseJdbcRepository;

/**
 * 业务 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface GenTableMapper extends BaseJdbcRepository<GenTable, Long> {

  /**
   * 查询业务列表
   *
   * @param genTable 业务信息
   * @return 业务集合
   */
  public List<GenTable> findGenTableList(GenTableQuery genTable);

  /**
   * 查询据库列表
   *
   * @param genTable 业务信息
   * @return 数据库表集合
   */
  public List<GenTable> findDbTableList(GenTable genTable);

  /**
   * 查询据库列表
   *
   * @param tableNames 表名称组
   * @return 数据库表集合
   */
  public List<GenTable> findDbTableListByNames(List<String> tableNames);

  /**
   * 查询所有表信息
   *
   * @return 表信息集合
   */
  public List<GenTable> findGenTableAll();

  /**
   * 查询表ID业务信息
   *
   * @param id 业务ID
   * @return 业务信息
   */
  public GenTable findGenTableById(Long id);

  /**
   * 查询表名称业务信息
   *
   * @param tableName 表名称
   * @return 业务信息
   */
  public GenTable findGenTableByName(String tableName);


  Long countGenTableList(GenTableQuery genTable);
}
