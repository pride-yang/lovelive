package top.yang.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yang.collections.CollectionUtils;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.domain.entity.SysDictData;
import top.yang.domain.query.SysConfigQuery;
import top.yang.domain.query.SysDictDataQuery;
import top.yang.request.SysDictDataReq;
import top.yang.response.SysConfigRes;
import top.yang.response.SysDictDataRes;
import top.yang.service.SysDictDataService;
import top.yang.service.SysDictTypeService;
import top.yang.web.annotation.ControllerLog;
import top.yang.web.controller.BaseController;
import top.yang.web.enums.BusinessType;

/**
 * @author PrideYang
 */
@Controller
@RequestMapping("/dict/data")
public class SysDictDataController extends BaseController {

    @Autowired
    private SysDictTypeService dictTypeService;
    @Autowired
    private SysDictDataService dictDataService;

    @PostMapping("/list")
    public PageResult<SysDictDataDto> list(SysDictDataReq dictData) {
        SysDictDataQuery sysConfigQuery = new SysDictDataQuery();
        BeanUtils.copyProperties(dictData, sysConfigQuery);
        return dictDataService.findDictDataPage(sysConfigQuery);
    }

    /**
     * 查询字典数据详细
     */

    @PostMapping(value = "/{dictCode}")
    public SysDictDataDto getInfo(@PathVariable Long dictCode) {
        return dictDataService.findDictDataById(dictCode);
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @PostMapping(value = "/type/{dictType}")
    public List<SysDictDataDto> dictType(@PathVariable String dictType) {
        return dictTypeService.findDictDataByType(dictType);
    }

    /**
     * 新增字典类型
     */

    @ControllerLog(title = "字典数据", businessType = BusinessType.INSERT)
    @PostMapping
    public void add(@RequestBody SysDictDataDto dict) {
        dictDataService.saveOrUpdate(dict);
    }


    /**
     * 删除字典类型
     */

    @ControllerLog(title = "字典类型", businessType = BusinessType.DELETE)
    @PostMapping("/{dictCodes}")
    public void remove(@PathVariable Long[] dictCodes) {
        dictDataService.deleteDictDataByIds(dictCodes);
    }
}