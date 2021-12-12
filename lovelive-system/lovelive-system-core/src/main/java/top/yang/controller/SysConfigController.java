package top.yang.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yang.domain.dto.PageResult;
import top.yang.domain.query.SysConfigQuery;
import top.yang.response.SysConfigReq;
import top.yang.service.SysConfigService;
import top.yang.web.controller.BaseController;

/**
 * @author PrideYang
 */
@Controller
@RequestMapping("/config")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigService sysConfigService;


    public PageResult<SysConfigReq> list(SysConfigReq req) {
        SysConfigQuery sysConfigQuery = new SysConfigQuery();
        BeanUtils.copyProperties(req, sysConfigQuery);
        return sysConfigService.findListByPage(sysConfigQuery);
    }
}
