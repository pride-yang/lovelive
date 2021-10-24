package top.yang.domain.entity;

import lombok.Data;
import top.yang.pojo.BaseBean;

/**
 * 角色和菜单关联 sys_role_menu
 *
 * @author ruoyi
 */
@Data
public class SysRoleMenu extends BaseBean {

  /**
   * 角色ID
   */
  private Long roleId;

  /**
   * 菜单ID
   */
  private Long menuId;


}
