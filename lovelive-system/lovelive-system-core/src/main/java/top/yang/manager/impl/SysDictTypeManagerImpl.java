package top.yang.manager.impl;

import top.yang.component.SysDictTypeComponent;
import top.yang.domain.dto.SysDictTypeDto;
import top.yang.manager.SysDictTypeManager;
import top.yang.domain.entity.SysDictType;
import org.springframework.stereotype.Component;

/**
 * @author PrideYang
 */
@Component
public class SysDictTypeManagerImpl extends BaseManagerImpl<SysDictTypeComponent, SysDictTypeDto, Long> implements SysDictTypeManager {

    @Override
    public Class getEntityClass() {
        return SysDictType.class;
    }
}