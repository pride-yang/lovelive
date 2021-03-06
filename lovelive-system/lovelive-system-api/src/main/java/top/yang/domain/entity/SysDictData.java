package top.yang.domain.entity;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;

@Data
@Table("sys_dict_data")
public class SysDictData extends BaseEntity {


    /**
     * 主键
     **/
    @Id
    private Long dictDataId;
    /**
     * 字典编码
     **/
    private String dictCode;
    /**
     * 字典排序
     **/
    private Integer dictSort;
    /**
     * 字典标签
     **/
    private String dictLabel;
    /**
     * 字典键值
     **/
    private String dictValue;
    /**
     * 字典类型
     **/
    private String dictType;
    /**
     * 样式属性（其他样式扩展）
     **/
    private String cssClass;
    /**
     * 表格回显样式
     **/
    private String listClass;
    /**
     * 是否默认（Y是 N否）
     **/
    private String isDefault;
    /**
     * 状态（0正常 1停用）
     **/
    private String status;
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