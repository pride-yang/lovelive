package top.yang.domain.entity;


import lombok.Data;
import top.yang.pojo.BaseBean;
import top.yang.pojo.BaseEntity;

/**
 * 参数配置表 sys_config
 *
 * @author ruoyi
 */
@Data
public class SysConfig extends BaseEntity {


  /**
   * 参数主键
   */

  private Long configId;

  /**
   * 参数名称
   */

  private String configName;

  /**
   * 参数键名
   */

  private String configKey;

  /**
   * 参数键值
   */

  private String configValue;

  /**
   * 系统内置（Y是 N否）
   */

  private String configType;

  private String createBy;
  private String updateBy;

}
