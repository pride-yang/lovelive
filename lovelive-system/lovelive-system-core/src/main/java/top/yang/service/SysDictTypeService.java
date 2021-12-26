package top.yang.service;

import java.util.List;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.domain.dto.SysDictTypeDto;
import top.yang.domain.entity.SysDictType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.domain.query.SysDictTypeQuery;
import top.yang.manager.impl.SysDictTypeManagerImpl;
import top.yang.request.SysDictTypeReq;

/**
 * @author PrideYang
 */
@Service
public class SysDictTypeService {

    @Autowired
    private SysDictTypeManagerImpl sysDictTypeManager;

    public List<SysDictDataDto> findDictDataByType(String dictType) {
        return null;
    }

    public void saveOrUpdate(SysDictTypeDto dict) {

    }

    public SysDictTypeDto findByDictId(Long dictId) {
        return null;
    }

    public PageResult<SysDictTypeDto> findDictTypePage(SysDictTypeQuery dictType) {
        return null;
    }

    public void deleteDictTypeByIds(Long[] dictIds) {

    }

    public List<SysDictTypeDto> findAll() {
        return sysDictTypeManager.findAll();
    }
}