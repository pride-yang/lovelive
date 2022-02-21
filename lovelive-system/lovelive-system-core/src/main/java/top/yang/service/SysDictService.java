package top.yang.service;

import java.util.List;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.domain.dto.SysDictTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.domain.query.SysDictDataQuery;
import top.yang.domain.query.SysDictQuery;
import top.yang.domain.query.SysDictTypeQuery;
import top.yang.manager.SysDictDataManager;
import top.yang.manager.SysDictTypeManager;

/**
 * @author PrideYang
 */
@Service
public class SysDictService {

    @Autowired
    private SysDictTypeManager sysDictTypeManager;

    @Autowired
    private SysDictDataManager sysDictDataManager;

    public PageResult<SysDictTypeDto> findDictTypeByPage(SysDictTypeQuery dictQuery) {
        sysDictTypeManager.findByQuery();
        return null;
    }

    public PageResult<SysDictDataDto> findDictDataByPage(SysDictDataQuery dictQuery) {

        return null;
    }

    public PageResult<SysDictDataDto> findByPage(SysDictQuery dictQuery) {
        return null;
    }

    public void updateData(SysDictDataDto dto) {

    }

    public void updateType(SysDictTypeDto dto) {

    }
}