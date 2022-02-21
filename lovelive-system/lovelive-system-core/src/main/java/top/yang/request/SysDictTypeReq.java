package top.yang.request;

import top.yang.domain.query.SysDictTypeQuery;
import top.yang.web.request.BaseReq;
import top.yang.web.request.PageReq;

/**
 * @author PrideYang
 */
public class SysDictTypeReq {

    /**
     * 字典主键
     **/
    private Long dictId;
    /**
     * 字典名称
     **/
    private String dictName;
    /**
     * 字典类型
     **/
    private String dictType;
    /**
     * 状态（0正常 1停用）
     **/
    private String status;

    /**
     * 备注
     **/
    private String remark;
}
