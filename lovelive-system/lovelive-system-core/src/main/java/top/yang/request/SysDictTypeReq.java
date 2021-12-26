package top.yang.request;

import top.yang.domain.query.SysDictTypeQuery;
import top.yang.web.request.BaseReq;
import top.yang.web.request.PageReq;

/**
 * @author PrideYang
 */
public class SysDictTypeReq extends PageReq {

    public SysDictTypeQuery toPageQuery() {
        return new SysDictTypeQuery();


    }
}
