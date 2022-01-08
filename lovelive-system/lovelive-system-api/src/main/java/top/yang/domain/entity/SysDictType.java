package top.yang.domain.entity;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;
@Data
@Table("sys_dict_type")
public class SysDictType extends BaseEntity {


  /**
   * 字典主键
  **/
  @Id
  private Long dictId;
  /**
   * 字典名称
  **/
  private String dictName;
  /**
   * 字典类型
  **/
  private String dictType;
  /**
   * 状态（0正常 1停用）
  **/
  private String status;
  /**
   * 创建者
  **/
  private String createBy;
  /**
   * 更新者
  **/
  private String updateBy;
  /**
   * 备注
  **/
  private String remark;
}