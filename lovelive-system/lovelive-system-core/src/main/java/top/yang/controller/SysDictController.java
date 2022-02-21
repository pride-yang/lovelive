package top.yang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yang.convers.SysConfigConver;
import top.yang.convers.SysDictConver;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.domain.dto.SysDictTypeDto;
import top.yang.domain.query.SysDictDataQuery;
import top.yang.domain.query.SysDictQuery;
import top.yang.domain.query.SysDictTypeQuery;
import top.yang.request.SysDictDataReq;
import top.yang.request.SysDictTypeReq;
import top.yang.response.SysDictDataRes;
import top.yang.response.SysDictTypeRes;
import top.yang.service.SysDictService;
import top.yang.web.controller.BaseController;

/**
 * @author pride
 */
@Controller
@RequestMapping("dict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService dictService;

    @PostMapping("/type/list")
    @ResponseBody
    public PageResult<SysDictTypeRes> typeList(@RequestBody SysDictTypeQuery dictQuery) {
        PageResult<SysDictTypeDto> list = dictService.findDictTypeByPage(dictQuery);
        return SysDictConver.INSTANCE.typeDtoToResPage(list);
    }

    @PostMapping("/type/saveOrUpdate")
    @ResponseBody
    public void updateType(@RequestBody SysDictTypeReq dictTypeReq) {
        SysDictTypeDto dto = SysDictConver.INSTANCE.typeReqToDto(dictTypeReq);
        dictService.updateType(dto);
    }

    @PostMapping("/data/list")
    @ResponseBody
    public PageResult<SysDictDataRes> dataList(@RequestBody SysDictDataQuery dictQuery) {
        PageResult<SysDictDataDto> list = dictService.findDictDataByPage(dictQuery);
        return SysDictConver.INSTANCE.dataDtoToResPage(list);
    }

    @PostMapping("/data/saveOrUpdate")
    @ResponseBody
    public void updateData(@RequestBody SysDictDataReq dictDataReq) {
        SysDictDataDto dto = SysDictConver.INSTANCE.dataReqToDto(dictDataReq);
        dictService.updateData(dto);
    }


}