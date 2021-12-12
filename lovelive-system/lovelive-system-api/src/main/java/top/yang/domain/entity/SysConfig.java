package top.yang.domain.entity;


import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;

/**
 * 参数配置表 sys_config
 *
 * @author ruoyi
 */
@Data
@Table("sys_config")
public class SysConfig extends BaseEntity {


  /**
   * 参数主键
   */
  @Id
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
