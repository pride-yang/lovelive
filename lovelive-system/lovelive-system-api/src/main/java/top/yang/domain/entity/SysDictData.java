package top.yang.domain.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.constants.SystemConstants;
import top.yang.domain.pojo.BaseEntity;

/**
 * 字典数据表 sys_dict_data
 *
 * @author ruoyi
 */
@Data
@Table("sys_dict_data")
public class SysDictData extends BaseEntity {


  /**
   * 字典编码
   */
  @Id
  private Long dictCode;

  /**
   * 字典排序
   */

  private Long dictSort;

  /**
   * 字典标签
   */

  private String dictLabel;

  /**
   * 字典键值
   */

  private String dictValue;

  /**
   * 字典类型
   */

  private String dictType;

  /**
   * 样式属性（其他样式扩展）
   */
  private String cssClass;

  /**
   * 表格字典样式
   */
  private String listClass;

  /**
   * 是否默认（Y是 N否）
   */

  private String isDefault;

  /**
   * 状态（0正常 1停用）
   */

  private String status;


  public void setListClass(String listClass) {
    this.listClass = listClass;
  }

  public boolean getDefault() {
    return SystemConstants.YES.equals(this.isDefault);
  }

  public String getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(String isDefault) {
    this.isDefault = isDefault;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
