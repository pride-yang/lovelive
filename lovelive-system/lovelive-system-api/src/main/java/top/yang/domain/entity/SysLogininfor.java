package top.yang.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import top.yang.pojo.BaseEntity;

/**
 * 系统访问记录表 sys_logininfor
 *
 * @author ruoyi
 */
@Data
public class SysLogininfor extends BaseEntity {


  /**
   * ID
   */

  private Long infoId;

  /**
   * 用户账号
   */

  private String userName;

  /**
   * 登录状态 0成功 1失败
   */

  private String status;

  /**
   * 登录IP地址
   */

  private String ipaddr;

  /**
   * 登录地点
   */

  private String loginLocation;

  /**
   * 浏览器类型
   */

  private String browser;

  /**
   * 操作系统
   */

  private String os;

  /**
   * 提示消息
   */

  private String msg;

  /**
   * 访问时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date loginTime;
  private String createBy;
  private String updateBy;
}
