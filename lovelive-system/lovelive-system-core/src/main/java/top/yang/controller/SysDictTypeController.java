package top.yang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictTypeDto;
import top.yang.domain.entity.SysDictType;
import top.yang.request.SysDictTypeReq;
import top.yang.service.SysDictTypeService;
import top.yang.web.annotation.ControllerLog;
import top.yang.web.controller.BaseController;
import top.yang.web.enums.BusinessType;

/**
 * @author PrideYang
 */
@Controller
@RequestMapping("/dict/type")
public class SysDictTypeController extends BaseController {

    @Autowired
    private SysDictTypeService dictTypeService;

    @ControllerLog(title = "字典类型", businessType = BusinessType.EXPORT)
    @PostMapping("/list")
    public PageResult<SysDictTypeDto> list(SysDictTypeReq dictType) {
        PageResult<SysDictTypeDto> list = dictTypeService.findDictTypePage(dictType.toPageQuery());
        return list;
    }

    /**
     * 查询字典类型详细
     */

    @PostMapping(value = "/{dictId}")
    public SysDictTypeDto getInfo(@PathVariable Long dictId) {
        return dictTypeService.findByDictId(dictId);
    }

    /**
     * 新增字典类型
     */

    @ControllerLog(title = "字典类型", businessType = BusinessType.INSERT)
    @PostMapping
    public void add(@RequestBody SysDictTypeDto dict) {
        dictTypeService.saveOrUpdate(dict);
    }

    /**
     * 删除字典类型
     */

    @ControllerLog(title = "字典类型", businessType = BusinessType.DELETE)
    @PostMapping("/{dictIds}")
    public void remove(@PathVariable Long[] dictIds) {
        dictTypeService.deleteDictTypeByIds(dictIds);
    }

    /**
     * 获取字典选择框列表
     */
    @PostMapping("/optionselect")
    public List<SysDictTypeDto> optionselect() {
        return dictTypeService.findAll();
    }
}