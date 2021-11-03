package top.yang.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;


/**
 * 部门表 sys_dept
 *
 * @author ruoyi
 */
@Data
@Table("sys_dept")
public class SysDept extends BaseEntity {


  /**
   * 部门ID
   */
  @Id
  private Long deptId;

  /**
   * 父部门ID
   */
  private Long parentId;

  /**
   * 祖级列表
   */
  private String ancestors;

  /**
   * 部门名称
   */
  private String deptName;

  /**
   * 显示顺序
   */
  private String orderNum;

  /**
   * 负责人
   */
  private String leader;

  /**
   * 联系电话
   */
  private String phone;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 部门状态:0正常,1停用
   */
  private String status;

  /**
   * 删除标志（0代表存在 2代表删除）
   */
  private String delFlag;

  /**
   * 父部门名称
   */
  private String parentName;
  private String createBy;
  private String updateBy;
}
