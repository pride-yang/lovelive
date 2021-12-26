package top.yang.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.domain.query.SysConfigQuery;
import top.yang.reflect.ObjectUtils;
import top.yang.request.SysConfigReq;
import top.yang.response.SysConfigRes;
import top.yang.service.SysConfigService;
import top.yang.web.annotation.ControllerLog;
import top.yang.web.controller.BaseController;
import top.yang.web.enums.BusinessType;

/**
 * @author PrideYang
 */
@Controller
@RequestMapping("/config")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigService sysConfigService;

    @PostMapping("/list")
    @ControllerLog(title = "参数管理", businessType = BusinessType.SEARCH)
    public PageResult<SysConfigDto> list(SysConfigReq req) {
        SysConfigQuery sysConfigQuery = new SysConfigQuery();
        BeanUtils.copyProperties(req, sysConfigQuery);

        return sysConfigService.findListByQuery(sysConfigQuery);
    }

    /**
     * 根据参数编号获取详细信息
     */
    @PostMapping(value = "/{configId}")
    public SysConfigDto getInfo(@PathVariable Long configId) {

        return sysConfigService.findByConfigId(configId);
    }


    /**
     * 新增或修改参数配置
     */
    @ControllerLog(title = "参数管理", businessType = BusinessType.INSERT)
    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody SysConfigRes config) {

    }

    /**
     * 删除参数配置
     */
    @ControllerLog(title = "参数管理", businessType = BusinessType.DELETE)
    @PostMapping("/{configIds}")
    public void remove(@PathVariable Long[] configIds) {
        sysConfigService.deleteConfigByIds(configIds);
    }

}
