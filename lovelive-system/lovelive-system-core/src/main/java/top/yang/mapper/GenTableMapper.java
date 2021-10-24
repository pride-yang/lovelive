package top.yang.mapper;

import java.util.List;
import top.yang.domain.entity.GenTable;
import top.yang.repository.BaseJdbcRepository;

/**
 * 业务 数据层
 *
 * @author ruoyi
 */
public interface GenTableMapper extends BaseJdbcRepository<GenTable, Long> {

  /**
   * 查询业务列表
   *
   * @param genTable 业务信息
   * @return 业务集合
   */
  public List<GenTable> selectGenTableList(GenTable genTable);

  /**
   * 查询据库列表
   *
   * @param genTable 业务信息
   * @return 数据库表集合
   */
  public List<GenTable> selectDbTableList(GenTable genTable);

  /**
   * 查询据库列表
   *
   * @param tableNames 表名称组
   * @return 数据库表集合
   */
  public List<GenTable> selectDbTableListByNames(String[] tableNames);

  /**
   * 查询所有表信息
   *
   * @return 表信息集合
   */
  public List<GenTable> selectGenTableAll();

  /**
   * 查询表ID业务信息
   *
   * @param id 业务ID
   * @return 业务信息
   */
  public GenTable selectGenTableById(Long id);

  /**
   * 查询表名称业务信息
   *
   * @param tableName 表名称
   * @return 业务信息
   */
  public GenTable selectGenTableByName(String tableName);

  /**
   * 新增业务
   *
   * @param genTable 业务信息
   * @return 结果
   */
  public int insertGenTable(GenTable genTable);

  /**
   * 修改业务
   *
   * @param genTable 业务信息
   * @return 结果
   */
  public int updateGenTable(GenTable genTable);

}
