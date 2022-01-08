package top.yang.domain.dto;
import java.util.Date;
import lombok.Data;
@Data
public class SysDictTypeDto extends BaseDto {


  /**
   * 字典主键
  **/
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