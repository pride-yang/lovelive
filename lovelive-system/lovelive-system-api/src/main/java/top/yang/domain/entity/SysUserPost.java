package top.yang.domain.entity;

import lombok.Data;
import top.yang.domain.pojo.BaseBean;

/**
 * 用户和岗位关联 sys_user_post
 *
 * @author ruoyi
 */
@Data
public class SysUserPost extends BaseBean {

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * 岗位ID
   */
  private Long postId;

}
