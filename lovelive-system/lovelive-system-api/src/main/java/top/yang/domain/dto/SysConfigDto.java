package top.yang.domain.dto;

import org.springframework.data.annotation.Id;
import top.yang.spring.dto.BaseDto;

/**
 * @author PrideYang
 */
public class SysConfigDto extends BaseDto {

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

    private Long createBy;


    private Long updateBy;
}
