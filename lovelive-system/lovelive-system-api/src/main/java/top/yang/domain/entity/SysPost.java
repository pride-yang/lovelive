package top.yang.domain.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;

/**
 * 岗位表 sys_post
 *
 * @author ruoyi
 */
@Data
@Table("sys_post")
public class SysPost extends BaseEntity {

  

  /**
   * 岗位序号
   */

  private Long postId;

  /**
   * 岗位编码
   */

  private String postCode;

  /**
   * 岗位名称
   */

  private String postName;

  /**
   * 岗位排序
   */

  private String postSort;

  /**
   * 状态（0正常 1停用）
   */

  private String status;

  /**
   * 用户是否存在此岗位标识 默认不存在
   */
  private boolean flag = false;
  private String createBy;
  private String updateBy;
 
}
