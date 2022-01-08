package top.yang.domain.entity;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;
@Data
@Table("sys_role")
public class SysRole extends BaseEntity {


  /**
   * 角色ID
  **/
  @Id
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