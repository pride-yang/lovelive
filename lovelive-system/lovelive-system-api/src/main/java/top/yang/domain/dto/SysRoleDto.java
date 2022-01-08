package top.yang.domain.dto;
import java.util.Date;
import lombok.Data;
@Data
public class SysRoleDto extends BaseDto {


  /**
   * 角色ID
  **/
  private Long roleId;
  /**
   * 角色名称
  **/
  private String roleName;
  /**
   * 角色权限字符串
  **/
  private String roleKey;
  /**
   * 显示顺序
  **/
  private Integer roleSort;
  /**
   * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
  **/
  private String dataScope;
  /**
   * 角色状态（0正常 1停用）
  **/
  private String status;
  /**
   * 备注
  **/
  private String remark;
}