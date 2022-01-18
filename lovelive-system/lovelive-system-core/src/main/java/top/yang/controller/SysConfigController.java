package top.yang.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.request.SysConfigReq;
import top.yang.service.SysConfigService;
import top.yang.web.controller.BaseController;

/**
 * @author pride
 */
@Controller
@RequestMapping("config")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigService sysConfigService;

    @PostMapping("saveOrUpdate")
    @ResponseBody
    public void saveOrUpdate(@RequestBody SysConfig sysConfig) {
        sysConfigService.saveOrUpdate(sysConfig);
    }

    @PostMapping("search")
    @ResponseBody
    public PageResult<SysConfigDto> search(@RequestBody SysConfigQuery sysConfig) {
        return sysConfigService.search(sysConfig);
    }
}