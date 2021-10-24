package top.yang.domain.entity;

import lombok.Data;
import top.yang.pojo.BaseBean;

/**
 * 角色和部门关联 sys_role_dept
 *
 * @author ruoyi
 */
@Data
public class SysRoleDept extends BaseBean {

  /**
   * 角色ID
   */
  private Long roleId;

  /**
   * 部门ID
   */
  private Long deptId;

}
