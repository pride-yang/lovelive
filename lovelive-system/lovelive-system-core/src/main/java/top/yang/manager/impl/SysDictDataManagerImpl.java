package top.yang.manager.impl;

import top.yang.component.SysDictDataComponent;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.manager.SysDictDataManager;
import top.yang.domain.entity.SysDictData;
import org.springframework.stereotype.Component;

/**
 * @author PrideYang
 */
@Component
public class SysDictDataManagerImpl extends BaseManagerImpl<SysDictDataComponent, SysDictDataDto, Long> implements SysDictDataManager {

    @Override
    public Class getEntityClass() {
        return SysDictData.class;
    }
}