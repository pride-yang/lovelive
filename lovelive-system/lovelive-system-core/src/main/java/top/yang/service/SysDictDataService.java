package top.yang.service;

import java.util.List;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.domain.dto.SysDictTypeDto;
import top.yang.domain.entity.SysDictData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.domain.query.SysDictDataQuery;
import top.yang.manager.impl.SysDictTypeManagerImpl;
import top.yang.request.SysDictDataReq;
import top.yang.response.SysDictDataRes;

/**
 * @author PrideYang
 */
@Service
public class SysDictDataService {

    @Autowired
    private SysDictTypeManagerImpl sysDictTypeManager;

    public SysDictDataDto findDictDataById(Long dictCode) {
        SysDictTypeDto byId = sysDictTypeManager.findById(dictCode);
        return null;
    }

    public List<SysDictDataDto> findDictDataList(SysDictDataQuery dictData) {
        return null;
    }

    public void saveOrUpdate(SysDictDataDto dict) {

    }

    public void deleteDictDataByIds(Long[] dictCodes) {
        sysDictTypeManager.deleteByIds(List.of(dictCodes));
    }

    public PageResult<SysDictDataDto> findDictDataPage(SysDictDataQuery sysConfigQuery) {
        return null;
    }
}