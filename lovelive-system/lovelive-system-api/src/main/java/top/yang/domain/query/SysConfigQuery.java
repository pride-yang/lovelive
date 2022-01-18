package top.yang.domain.query;

import lombok.Data;

/**
 * @author PrideYang
 */
@Data
public class SysConfigQuery extends PageQuery {

    /**
     * 参数主键
     */
    private Long configId;

    /**
     * 参数名称
     */
    private String configName;
    /**
     * 参数名称
     */
    private String configNameLike;

    /**
     * 参数键名
     */

    private String configKey;

    /**
     * 系统内置（Y是 N否）
     */

    private String configType;
}
