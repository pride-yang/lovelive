package top.yang.domain.entity;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.collections.ArrayUtils;

import top.yang.constants.GenConstants;
import top.yang.domain.pojo.BaseEntity;
import top.yang.string.StringUtils;


/**
 * 业务表 gen_table
 *
 * @author ruoyi
 */
@Data
@Table("gen_table")
public class GenTable extends BaseEntity {


  /**
   * 编号
   */
  @Id
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
   * 表列信息
   */
  private List<GenTableColumn> columns;

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

  public boolean isSub() {
    return isSub(this.tplCategory);
  }

  public static boolean isSub(String tplCategory) {
    return tplCategory != null && StringUtils.equals(GenConstants.TPL_SUB, tplCategory);
  }

  public boolean isTree() {
    return isTree(this.tplCategory);
  }

  public static boolean isTree(String tplCategory) {
    return tplCategory != null && StringUtils.equals(GenConstants.TPL_TREE, tplCategory);
  }

  public boolean isCrud() {
    return isCrud(this.tplCategory);
  }

  public static boolean isCrud(String tplCategory) {
    return tplCategory != null && StringUtils.equals(GenConstants.TPL_CRUD, tplCategory);
  }

  public boolean isSuperColumn(String javaField) {
    return isSuperColumn(this.tplCategory, javaField);
  }

  public static boolean isSuperColumn(String tplCategory, String javaField) {
    if (isTree(tplCategory)) {
      return StringUtils.equalsAnyIgnoreCase(javaField,
          ArrayUtils.addAll(GenConstants.TREE_ENTITY, GenConstants.BASE_ENTITY));
    }
    return StringUtils.equalsAnyIgnoreCase(javaField, GenConstants.BASE_ENTITY);
  }
}