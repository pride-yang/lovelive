package top.yang.domain.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pride
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysConfigDto extends BaseDto {


    /**
     * 参数主键
     **/
    private Long configId;
    /**
     * 参数名称
     **/
    private String configName;
    /**
     * 参数键名
     **/
    private String configKey;
    /**
     * 参数键值
     **/
    private String configValue;
    /**
     * 系统内置（Y是 N否）
     **/
    private String configType;
    /**
     * 创建者
     **/
    private String createBy;
    /**
     * 更新者
     **/
    private String updateBy;
    /**
     * 备注
     **/
    private String remark;
}