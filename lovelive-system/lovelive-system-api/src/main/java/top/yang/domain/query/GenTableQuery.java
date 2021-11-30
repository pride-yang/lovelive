package top.yang.domain.query;

import java.time.LocalDateTime;
import lombok.Data;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.GenTableColumn;

/**
 * @author pride
 */
@Data
public class GenTableQuery extends PageQuery {

  /**
   * 编号
   */
  private Long tableId;

  /**
   * 表名称
   */

  private String tableName;

  /**
   * 表描述
   */

  private String tableComment;

  /**
   * 关联父表的表名
   */
  private String subTableName;

  /**
   * 本表关联父表的外键名
   */
  private String subTableFkName;

  /**
   * 实体类名称(首字母大写)
   */

  private String className;

  /**
   * 使用的模板（crud单表操作 tree树表操作 sub主子表操作）
   */
  private String tplCategory;

  /**
   * 生成包路径
   */

  private String packageName;

  /**
   * 生成模块名
   */

  private String moduleName;

  /**
   * 生成业务名
   */

  private String businessName;

  /**
   * 生成功能名
   */

  private String functionName;

  /**
   * 生成作者
   */

  private String functionAuthor;

  /**
   * 生成代码方式（0zip压缩包 1自定义路径）
   */
  private String genType;

  /**
   * 生成路径（不填默认项目路径）
   */
  private String genPath;

  /**
   * 主键信息
   */
  private GenTableColumn pkColumn;

  /**
   * 子表信息
   */
  private GenTable subTable;

  /**
   * 其它生成选项
   */
  private String options;

  /**
   * 树编码字段
   */
  private String treeCode;

  /**
   * 树父编码字段
   */
  private String treeParentCode;

  /**
   * 树名称字段
   */
  private String treeName;

  /**
   * 上级菜单ID字段
   */
  private String parentMenuId;

  /**
   * 上级菜单名称字段
   */
  private String parentMenuName;

  private LocalDateTime beginTime;

  private LocalDateTime endTime;
}
