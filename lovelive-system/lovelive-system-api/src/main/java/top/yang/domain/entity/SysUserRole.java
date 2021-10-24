package top.yang.domain.entity;


import lombok.Data;
import top.yang.pojo.BaseBean;

/**
 * 用户和角色关联 sys_user_role
 *
 * @author ruoyi
 */
@Data
public class SysUserRole extends BaseBean {

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * 角色ID
   */
  private Long roleId;

}
